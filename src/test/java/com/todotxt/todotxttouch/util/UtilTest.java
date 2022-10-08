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
}
