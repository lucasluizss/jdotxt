package com.todotxt.todotxttouch.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;
import com.todotxt.todotxttouch.TodoException;
import org.junit.rules.ExpectedException;

import javax.swing.*;

import static org.junit.Assert.*;

public class UtilTest {
	private static String DEFAULTDIR;
	private static String NON_EXISTING_DIR;
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

	/**
	 * Testing createParentDirectory function
	 */

	@Test(expected = TodoException.class)
	public void testNullDestination() throws IOException, TodoException {
		// arange
		File dest = null;

		// act & assert
		Util.createParentDirectory(dest);
	}

	@Test
	public void testParentDirectoryExist() throws IOException, TodoException {
		// arange
		File dest = TODO_TXT_FILE;
		String parentPath = DEFAULTDIR;

		// act
		Util.createParentDirectory(dest);

		// assert
		assertEquals(parentPath, TODO_TXT_FILE.getParent());
	}

	@Test
	public void testParentDirectoryValid() throws IOException, TodoException {
		// arange
		String parentPath = System.getProperty("user.home") + File.separator + "unexisting_dir";
		File dest = new File(parentPath + File.separator + "todo.txt");

		// act
		Util.createParentDirectory(dest);

		// assert
		assertEquals(parentPath, dest.getParent());

		File dir = new File(parentPath);
		if (dir.exists()) {
			dir.delete();
		}
	}

	/**
	 * Testing renameFile function
	 */

	@Test
	public void testRenamingFile() throws IOException, TodoException {
		String oldFilePath = DEFAULTDIR + File.separator + "todo0.txt";
		File oldFile = new File(oldFilePath);
		String renamedFilePath = DEFAULTDIR + File.separator + "todo1.txt";
		File renamedFile = new File(renamedFilePath);
		String expected = renamedFile.getPath();

		oldFile.createNewFile();
		Util.renameFile(oldFile, renamedFile, false);

		assertEquals(expected, renamedFilePath);
	}

	@Test
	public void testRenamingFileOverwrite() throws IOException, TodoException {
		String origFileName = DEFAULTDIR + File.separator + "todo0.txt";
		File origFile = new File(origFileName);
		String renamedFilePath = DEFAULTDIR + File.separator + "todo1.txt";
		File renamedFile = new File(renamedFilePath);
		String expected = renamedFile.getPath();

		origFile.createNewFile();
		renamedFile.createNewFile();
		Util.renameFile(origFile, renamedFile, true);

		assertEquals(expected, renamedFilePath);
		if (origFile.exists()) {
			origFile.delete();
		}
		if (renamedFile.exists()) {
			renamedFile.delete();
		}
	}

	@Test(expected = NullPointerException.class)
	public void testRenamingNullFile() throws IOException, TodoException {
		// arange
		File file = TODO_TXT_FILE;
		File origFile = null;
		File newFile = null;
		boolean overwrite = false;

		// act & assert
		file.createNewFile();
		Util.renameFile(origFile, newFile, overwrite);
	}

	@Test(expected = TodoException.class)
	public void testRenamingNonExistentFile() throws IOException, TodoException {
		// arange
		File file = TODO_TXT_FILE;
		String nonexistentFilePath = DEFAULTDIR + File.separator + "todo999.txt";
		File nonexistentFile = new File(nonexistentFilePath);

		// act & assert
		file.createNewFile();
		Util.renameFile(nonexistentFile, file, false);
	}

	@Test
	public void testCopyFile() throws IOException, TodoException {
		File file = TODO_TXT_FILE;
		String filePath = DEFAULTDIR + File.separator + "todo_new.txt";
		File newFile = new File(filePath);

		file.createNewFile();
		Util.copyFile(file, newFile, false);
		if (newFile.exists()) {
			newFile.delete();
		}
	}

	@Test(expected = NullPointerException.class)
	public void testCopyFileNull() throws IOException, TodoException {
		File file = TODO_TXT_FILE;
		File origFile = null;
		File newFile = null;
		boolean overwrite = false;

		file.createNewFile();
		Util.copyFile(origFile, newFile, overwrite);
	}

	@Test
	public void testCloseStream() {
		InputStream targetStream = null;

		Util.closeStream(targetStream);
	}

	@Test
	public void testReadStream() {
		String initialString = "some text";
		InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());
		String returned = Util.readStream(targetStream);

		assertEquals("some text", returned);
	}

	@Test
	public void testReadStreamNull() {
		String returned = Util.readStream(null);

		assertNull(returned);
	}

	@Test
	public void testWriteFile() throws IOException {
		File file = TODO_TXT_FILE;
		file.createNewFile();

		String initialString = "some text";
		InputStream targetStream = new ByteArrayInputStream(initialString.getBytes());

		Util.writeFile(targetStream, file);

		Scanner reader = new Scanner(file);
		while (reader.hasNextLine()) {
			String data = reader.nextLine();
			assertEquals("some text", data);
		}
	}

	@Test
	public void testIntegerList2IntArray() {
		List<Integer> list = new ArrayList<>();
		list.add(1);

		int[] array = new int[1];
		array[0] = 1;

		int[] returned = Util.integerList2IntArray(list);

		assertEquals(array.length, returned.length);
		for (int i = 0; i<array.length; i++) {
			assertEquals(array[i], returned[i]);
		}
	}

	@Test
	public void testPrependString() {
		ArrayList<String> list = new ArrayList<>();
		list.add("test");

		Util.prependString(list, "prep");

		for (int i = 0; i<list.size(); i++) {
			assertEquals("preptest", list.get(i));
		}
	}

	@Test
	public void testCreateImageIconUnexisting() {
		String path = "unexisting";

		ImageIcon icon = Util.createImageIcon(path);

		assertNull(icon);
	}

	@Test
	public void testCreateImageIconExisting() throws IOException {
		String path = DEFAULTDIR + File.separator + "image.png";
		File image = new File(path);
		image.createNewFile();

		ImageIcon icon = Util.createImageIcon(path);

		assertNull(icon);
	}

	@Test
	public void testSplitBlank() {
		String s = "";
		String delimeter = " ";

		ArrayList<String> returned = Util.split(s, delimeter);

		assertEquals(0, returned.size());
	}

	@Test
	public void testSplit() {
		String s = "test test";
		String delimeter = " ";

		ArrayList<String> returned = Util.split(s, delimeter);

		assertEquals(2, returned.size());
		assertEquals("test", returned.get(0));
		assertEquals("test", returned.get(1));
	}

	@Test
	public void testJoinBlank() {
		List<String> s = null;
		String delimeter = " ";

		String returned = Util.join(s, delimeter);

		assertEquals("", returned);
	}

	@Test
	public void testJoin() {
		List<String> s = new ArrayList<>();
		s.add("test1");
		s.add("test2");
		String delimeter = " ";

		String returned = Util.join(s, delimeter);

		assertEquals("test1 test2", returned);
	}

	@Test
	public void testIsWritable() {
		boolean isWritable = Util.isDeviceWritable();
		assertTrue(isWritable);
	}

	@Test
	public void testIsReadable() {
		boolean isReadable = Util.isDeviceReadable();
		assertTrue(isReadable);
	}
}
