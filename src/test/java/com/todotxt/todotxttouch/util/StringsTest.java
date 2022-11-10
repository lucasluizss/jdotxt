package com.todotxt.todotxttouch.util;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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

	@Test
	public void testInsertPaddedStringToInsertNull() {
		String s = "test";
		int insertAt = 0;
		String stringToInsert = "";

		String returned = Strings.insertPadded(s, insertAt, stringToInsert);

		assertEquals("test", returned);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testInsertPaddedIndexIncorrect() throws IndexOutOfBoundsException {
		String s = "test";
		int insertAt = -1;
		String stringToInsert = "test";

		thrown.expect(IndexOutOfBoundsException.class);
		Strings.insertPadded(s, insertAt, stringToInsert);
	}

	@Test
	public void testInsertPaddedIndexZero() {
		String s = "test";
		int insertAt = 0;
		String stringToInsert = "test";

		String returned = Strings.insertPadded(s, insertAt, stringToInsert);

		assertEquals("test test", returned);
	}

	@Test
	public void testInsertPaddedCorrect() {
		String s = "test";
		int insertAt = 1;
		String stringToInsert = "test";

		String returned = Strings.insertPadded(s, insertAt, stringToInsert);

		assertEquals("t test est", returned);
	}

	@Test
	public void testInsertPaddedCorrectWithSpace() {
		String s = "t est";
		int insertAt = 1;
		String stringToInsert = "test";

		String returned = Strings.insertPadded(s, insertAt, stringToInsert);

		assertEquals("t test est", returned);
	}

	@Test
	public void testInsertPaddedIfNeededEmptyInsert() {
		String s = "test";
		int insertAt = 0;
		String stringToInsert = "";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("test", returned);
	}

	@Test
	public void testInsertPaddedNotNeededIncluded() {
		String s = "te st";
		int insertAt = 0;
		String stringToInsert = "te";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("te st ", returned);
	}

	@Test
	public void testInsertPaddedNotNeededWithoutSpaces() {
		String s = "test";
		int insertAt = 1;
		String stringToInsert = "es";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("t es est", returned);
	}

	@Test
	public void testInsertPaddedNotNeededNotBeginning() {
		String s = " te st";
		int insertAt = 0;
		String stringToInsert = "te";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals(" te st ", returned);
	}

	@Test
	public void testInsertPaddedNotNeededEndSubstring() {
		String s = "te st";
		int insertAt = 0;
		String stringToInsert = "st";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("te st ", returned);
	}

	@Test
	public void testInsertPaddedNotNeededSpaceEnd() {
		String s = "te st ";
		int insertAt = 0;
		String stringToInsert = "te";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("te st ", returned);
	}

	@Test
	public void testInsertPaddedNotNeededNotIncluded() {
		Strings strings = new Strings();
		String s = "test";
		int insertAt = 0;
		String stringToInsert = "aa";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("aa test", returned);
	}

	@Test
	public void testInsertPaddedIfNeededIncorrectIndex() {
		String s = "";
		int insertAt = 0;
		String stringToInsert = "te";

		String returned = Strings.insertPaddedIfNeeded(s, insertAt, stringToInsert);

		assertEquals("te ", returned);
	}
}
