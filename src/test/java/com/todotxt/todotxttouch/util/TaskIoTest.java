package com.todotxt.todotxttouch.util;

import com.chschmid.jdotxt.Jdotxt;
import com.chschmid.jdotxt.gui.JdotxtGUI;
import com.chschmid.jdotxt.util.LanguagesController;
import com.todotxt.todotxttouch.task.Task;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class TaskIoTest {
    private static String DEFAULTDIR;
    private static File TODO_TXT_FILE;

    @BeforeClass
    public static void beforeClassFunction() {
        DEFAULTDIR = Jdotxt.DEFAULT_DIR;
        TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo.txt");
    }

    @AfterClass
    public static void afterClassFunction() throws IOException {
        deleteDefaultFile();
        deleteRenamedFile();
    }

    private static void deleteRenamedFile() {
        String renamedFilePath = DEFAULTDIR + File.separator + "todo1.txt";
        File renamedFile = new File(renamedFilePath);

        if (renamedFile.exists()) {
            renamedFile.delete();
        }
    }

    private static void deleteDefaultFile() {
        if (TODO_TXT_FILE.exists()) {
            TODO_TXT_FILE.delete();
        }
    }

    @Test
    public void testLoadTaskFromFileNull() throws IOException {
        File file = new File(DEFAULTDIR + File.separator + "todo11.txt");

        ArrayList<Task> tasks = TaskIo.loadTasksFromFile(file);
        assertEquals(0, tasks.size());
    }

    @Test
    public void testLoadTaskFromFile() throws IOException {
        JdotxtGUI.lang = new LanguagesController("English");
        File file = TODO_TXT_FILE;
        file.createNewFile();

        FileWriter myWriter = new FileWriter(file.getAbsolutePath());
        myWriter.write("2022-11-02 New task");
        myWriter.close();

        ArrayList<Task> tasks = TaskIo.loadTasksFromFile(file);
        assertEquals(1, tasks.size());
    }

    @Test
    public void testLoadTaskFromFileLineSeparator() throws IOException {
        JdotxtGUI.lang = new LanguagesController("English");
        File file = TODO_TXT_FILE;
        file.createNewFile();

        FileWriter myWriter = new FileWriter(file.getAbsolutePath());
        myWriter.write("2022-11-02 New task\r");
        myWriter.write("\r");
        myWriter.close();

        ArrayList<Task> tasks = TaskIo.loadTasksFromFile(file);
        assertEquals(1, tasks.size());
    }

    @Test
    public void testLoadTaskFromFileLineSeparator2() throws IOException {
        JdotxtGUI.lang = new LanguagesController("English");
        File file = TODO_TXT_FILE;
        file.createNewFile();

        FileWriter myWriter = new FileWriter(file.getAbsolutePath());
        myWriter.write("2022-11-02 New task\r\n");
        myWriter.close();

        ArrayList<Task> tasks = TaskIo.loadTasksFromFile(file);
        assertEquals(1, tasks.size());
    }

    @Test
    public void testWriteToFile() throws IOException {
        TaskIo taskIo = new TaskIo();
        File file = TODO_TXT_FILE;
        file.createNewFile();

        Task task1 = new Task(1, "text1");
        Task task2 = new Task(2, "text2\n");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        TaskIo.writeToFile(tasks, file);

        Scanner reader = new Scanner(file);
        int i = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            if (i == 0) {
                assertEquals("text1", data);
            }
            if (i == 1) {
                assertEquals("text2", data);
            }
            i++;
        }
        reader.close();
    }
}
