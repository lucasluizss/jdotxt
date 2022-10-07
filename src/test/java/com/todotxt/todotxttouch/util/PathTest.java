package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PathTest {

	/**
	 * Testing fileName function
	 */

	@Test
	public void testReturnsEmptyIfPathIsEmpty() {
		// arange
		String expected = "";
		String path = "";

		// act
		String actual = Path.fileName(path);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsCorrectFileNameIfPathStartsWithSlash() {
		// arange
		String expected = "test";
		String path = "/test";

		// act
		String actual = Path.fileName(path);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsCorrectFileNameIfPathEndsWithSlash() {
		// arange
		String expected = "test";
		String path = "test/";

		// act
		String actual = Path.fileName(path);

		// assert
		assertEquals(expected, actual);
	}

	/**
	 * Testing parentPath function
	 */

	@Test
	public void testReturnsEmptyIfParentPathIsEmpty() {
		// arange
		String expected = "";
		String path = "";

		// act
		String actual = Path.parentPath(path);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsCorrectParentPathIfPathStartsWithSlash() {
		// arange
		String expected = "/";
		String path = "/test";

		// act
		String actual = Path.parentPath(path);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsCorrectParentPathIfPathEndsWithSlash() {
		// arange
		String expected = "";
		String path = "test/";

		// act
		String actual = Path.parentPath(path);

		// assert
		assertEquals(expected, actual);
	}

}
