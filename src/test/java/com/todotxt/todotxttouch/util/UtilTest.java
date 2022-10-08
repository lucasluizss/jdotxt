package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;
import com.todotxt.todotxttouch.TodoException;

public class UtilTest {
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

	/**
	 * Testing createParentDirectory function
	 */

	@Test(expected = TodoException.class)
	public void testThrowsTodoExceptionWhenPassingNullDestitaion() throws IOException, TodoException {
		// arange
		File dest = null;

		// act & assert
		Util.createParentDirectory(dest);
	}

	@Test
	public void testParentDirectoryCreation() throws IOException, TodoException {
		// arange
		File dest = TODO_TXT_FILE;
		String parentPath = DEFAULTDIR;

		// act
		Util.createParentDirectory(dest);

		// assert
		assertEquals(parentPath, TODO_TXT_FILE.getParent());
	}

	/**
	 * Testing renameFile function
	 */

	@Test
	public void testRenamingFile() throws IOException, TodoException {
		// arange
		File file = TODO_TXT_FILE;
		String renamedFilePath = DEFAULTDIR + File.separator + "todo1.txt";
		File renamedFile = new File(renamedFilePath);
		String expected = renamedFile.getPath();

		// act
		file.createNewFile();
		Util.renameFile(file, renamedFile, false);

		// assert
		assertEquals(expected, renamedFilePath);
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
}
