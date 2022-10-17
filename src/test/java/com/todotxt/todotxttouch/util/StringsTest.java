package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringsTest {

	@Test
	public void insertPaddedE1() {
		// arange
		String expected = "test1 ";
		String s = "";
		int insertAt = 0;
		String stringToInsert = "test1";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test(expected = NullPointerException.class)
	public void insertPaddedE2() {
		// arange
		String s = null;
		int insertAt = 0;
		String stringToInsert = "test2";

		// act & assert
		Strings.insertPadded(s, insertAt, stringToInsert);
	}

	@Test
	public void insertPaddedE3() {
		// arange
		String expected = "test ";
		String s = " ";
		int insertAt = 0;
		String stringToInsert = "test";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedE4() {
		// arange
		String expected = "test 4";
		String s = "4";
		int insertAt = 0;
		String stringToInsert = "test";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertPaddedE5() {
		// arange
		String s = "5";
		int insertAt = -1;
		String stringToInsert = "test";

		// act & assert
		Strings.insertPadded(s, insertAt, stringToInsert);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void insertPaddedE6() {
		// arange
		String s = "6";
		int insertAt = 5;
		String stringToInsert = "test";

		// act & assert
		Strings.insertPadded(s, insertAt, stringToInsert);
	}

	@Test
	public void insertPaddedE7() {
		// arange
		String expected = "my 7th boundary";
		String s = "my boundary";
		int insertAt = 3;
		String stringToInsert = "7th";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedE8() {
		// arange
		String expected = "my boundary";
		String s = "my boundary";
		int insertAt = 3;
		String stringToInsert = "";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedE9() {
		// arange
		String expected = "my boundary";
		String s = "my boundary";
		int insertAt = 3;
		String stringToInsert = null;

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedE10() {
		// arange
		String expected = "my   boundary";
		String s = "myboundary";
		int insertAt = 2;
		String stringToInsert = " ";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void insertPaddedE11() {
		// arange
		String expected = "my 11th boundary";
		String s = "myboundary";
		int insertAt = 2;
		String stringToInsert = "11th";

		// act
		String actual = Strings.insertPadded(s, insertAt, stringToInsert);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void isEmptyOrNullE1() {
		// arange
		String s = "";

		// act
		Boolean actual = Strings.isEmptyOrNull(s);

		// assert
		assertTrue(actual);
	}

	@Test
	public void isEmptyOrNullE2() {
		// arange
		String s = null;

		// act
		Boolean actual = Strings.isEmptyOrNull(s);

		// assert
		assertTrue(actual);
	}

	@Test
	public void isEmptyOrNullE3() {
		// arange
		String s = " ";

		// act
		Boolean actual = Strings.isEmptyOrNull(s);

		// assert
		assertFalse(actual);
	}

	@Test
	public void isEmptyOrNullE4() {
		// arange
		String s = "asd";

		// act
		Boolean actual = Strings.isEmptyOrNull(s);

		// assert
		assertFalse(actual);
	}

	@Test
	public void isBlankE1() {
		// arange
		String s = "";

		// act
		Boolean actual = Strings.isBlank(s);

		// assert
		assertTrue(actual);
	}

	@Test
	public void isBlankE2() {
		// arange
		String s = null;

		// act
		Boolean actual = Strings.isBlank(s);

		// assert
		assertTrue(actual);
	}

	@Test
	public void isBlankE3() {
		// arange
		String s = "  ";

		// act
		Boolean actual = Strings.isBlank(s);

		// assert
		assertTrue(actual);
	}

	@Test
	public void isBlankE4() {
		// arange
		String s = "test";

		// act
		Boolean actual = Strings.isBlank(s);

		// assert
		assertFalse(actual);
	}
}