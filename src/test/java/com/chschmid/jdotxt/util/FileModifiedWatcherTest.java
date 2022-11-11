package com.chschmid.jdotxt.util;

import com.chschmid.jdotxt.Jdotxt;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static org.junit.Assert.assertEquals;

public class FileModifiedWatcherTest {
    File file;
    File file1;

    WatchKey key;

    WatchService watcher;

    FileModifiedWatcher test;

    //String baseDir = System.getProperty("user.dir");
    String baseDir = Jdotxt.DEFAULT_DIR;

    String path = baseDir.replace("\\", "/") + "/teste.txt";

    String path1 = baseDir.replace("\\", "/") + "/teste1.txt";;

    @Before
    public void setUp() throws IOException {
        test = new FileModifiedWatcher();
        watcher = FileSystems.getDefault().newWatchService();
        file = new File(path); // com/chschmid/jdotxt/util/DelayedActionHandler.java
        file1 = new File(path1);
        key  = null;
    }

    @Test
    public void registerFileTest() throws IOException {
        file1.createNewFile();
        file.createNewFile();

        /*The first one has to be File insted of String because the getPath goes to the previous file so
         * for the first one the file will be null an error will be thrown */
        File first = test.registerFile(file);
        String firstExpected = null;
        Assertions.assertEquals(firstExpected, first);

        String second = test.registerFile(file).getPath().replace("\\", "/");
        String secondExpected = path;
        Assertions.assertEquals(secondExpected, second);

        file.delete();
        file1.delete();
    }

    @Test
    public void getFileTest() throws IOException {
        file.createNewFile();
        test.registerFile(file);
        String actual = test.getFile().toString().replace("\\", "/");
        assertEquals(path, actual);

        file.delete();
    }

}
