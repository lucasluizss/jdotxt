package com.chschmid.jdotxt.util;

import com.chschmid.jdotxt.Jdotxt;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileSystems;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FileModifiedWatcherTest {
    File file;
    File secondFile;

    WatchKey key;

    WatchService watcher;

    FileModifiedWatcher test;

    FileModifiedListener listener, another_listener;

    //String baseDir = System.getProperty("user.dir");
    String baseDir = Jdotxt.DEFAULT_DIR;

    String path = baseDir.replace("\\", "/") + "/teste.txt";

    String secondPath = baseDir.replace("\\", "/") + "/teste1.txt";

    @Before
    public void setUp() throws IOException {
        test = new FileModifiedWatcher();
        watcher = FileSystems.getDefault().newWatchService();
        file = new File(path);
        secondFile = new File(secondPath);
        key  = null;
    }

    @Test
    public void registerFileTest() throws IOException {
        file.createNewFile();
        secondFile.createNewFile();

        /*The first one has to be File insted of String because the getPath goes to the previous file so
         * for the first one the file will be null an error will be thrown */
        File first = test.registerFile(file);
        Assertions.assertEquals(null, first);

        String actual = test.registerFile(secondFile).getPath().replace("\\", "/");
        String expected = path;
        Assertions.assertEquals(expected, actual);

        file.delete();
        secondFile.delete();
    }

    @Test
    public void unRegisterFile() throws IOException {
        file.createNewFile();
        
        File first = test.registerFile(file);
        test.unRegisterFile();
        assertNull(test.getFile());
    }

    @Test
    public void getFileTest() throws IOException {
        file.createNewFile();
        test.registerFile(file);
        String actual = test.getFile().toString().replace("\\", "/");
        assertEquals(path, actual);

        file.delete();
    }

    @Test
    public void addFileModifiedListenerTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("fileModifiedListenerList");
        f.setAccessible(true);
        ArrayList<FileModifiedListener> fileModifiedListenerList = (ArrayList<FileModifiedListener>) f.get(test);

        test.addFileModifiedListener(listener);
        int actual = fileModifiedListenerList.size();
        assertEquals(1, actual);
    }

    @Test
    public void removeFileModifiedListenerTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("fileModifiedListenerList");
        f.setAccessible(true);
        ArrayList<FileModifiedListener> fileModifiedListenerList = (ArrayList<FileModifiedListener>) f.get(test);

        test.addFileModifiedListener(listener);

        test.removeFileModifiedListener(listener);
        int actual = fileModifiedListenerList.size();
        Assertions.assertEquals(0, actual);
    }

    @Test
    public void addFileModifiedListenerMultipleTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("fileModifiedListenerList");
        f.setAccessible(true);
        ArrayList<FileModifiedListener> fileModifiedListenerList = (ArrayList<FileModifiedListener>) f.get(test);

        test.addFileModifiedListener(listener);
        test.addFileModifiedListener(another_listener);
        int actual = fileModifiedListenerList.size();
        Assertions.assertEquals(2, actual);

        test.removeFileModifiedListener(listener);
        actual = fileModifiedListenerList.size();
        Assertions.assertEquals(1, actual);
    }

    @Test
    public void startProcessingEventsTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("processing");
        f.setAccessible(true);

        test.startProcessingEvents();
        boolean actual = (boolean) f.get(test);

        assertTrue(actual);
    }

    @Test
    public void startProcessingEventsTwiceTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("processing");
        f.setAccessible(true);

        test.startProcessingEvents();
        test.startProcessingEvents();
        boolean actual = (boolean) f.get(test);

        assertTrue(actual);
    }

    @Test
    public void stopProcessingEventsTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("processing");
        f.setAccessible(true);

        test.startProcessingEvents();
        test.stopProcessingEvents();
        boolean actual = (boolean) f.get(test);

        assertFalse(actual);
    }

    @Test
    public void stopProcessingEventsWithoutStartTest() throws NoSuchFieldException, IllegalAccessException {
        Field f=FileModifiedWatcher.class.getDeclaredField("processing");
        f.setAccessible(true);

        test.stopProcessingEvents();
        boolean actual = (boolean) f.get(test);

        assertFalse(actual);
    }

}
