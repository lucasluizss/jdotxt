package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class RecParserTest {

	@Test
	public void parseEmptyStringTest() {
		RecParser parser = RecParser.getInstance();

		String[] actual = parser.parse("");

		assertNull(actual);
	}

	@Test
	public void parseTest() {
		RecParser parser = RecParser.getInstance();

		String[] expected = { "+", "123", "d" };
		String[] actual = parser.parse("rec:+123d");

		assertArrayEquals(expected, actual);
	}

}
