package com.chschmid.jdotxt.util;

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

    String path = "C:\\Users\\franc\\Desktop\\1ano_feup\\tvvs\\jdotxt\\src\\main\\java\\com\\chschmid\\jdotxt\\util\\teste.java";
    String path1 = "C:\\Users\\franc\\Desktop\\1ano_feup\\tvvs\\jdotxt\\src\\main\\java\\com\\chschmid\\jdotxt\\util\\teste1.java";

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
        file.createNewFile();
        file1.createNewFile();

        /*The first one has to be File insted of String because the getPath goes to the previous file so
         * for the first one the file will be null an error will be thrown */
        File first = test.registerFile(file);
        String firstExpected = null;
        Assertions.assertEquals(firstExpected, first);

        String second = test.registerFile(file).getPath();
        String secondExpected = path;
        Assertions.assertEquals(secondExpected, second);

        file.delete();
        file1.delete();
    }

    @Test
    public void getFileTest() throws IOException {
        file.createNewFile();
        test.registerFile(file);
        String actual = test.getFile().toString();
        assertEquals(path, actual);

        file.delete();
        file1.delete();
    }

}
