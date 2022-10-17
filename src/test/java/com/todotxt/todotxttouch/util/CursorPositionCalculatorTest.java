package com.todotxt.todotxttouch.util;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CursorPositionCalculatorTest {

	@Test
	public void testReturnsZeroIfNewValueIsNull() {
		// arange
		int expected = 0;
		int priorCursorPosition = 0;
		String newValue = null;
		String priorValue = null;

		// act
		int actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsNewValueLenghtIfPriorIsNull() {
		// arange
		int expected = 9;
		int priorCursorPosition = 0;
		String priorValue = null;
		String newValue = "New Value";

		// act
		int actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsNewPosition() {
		// arange
		int expected = 9;
		int priorCursorPosition = 10;
		String priorValue = "Old Value";
		String newValue = "New Value";

		// act
		int actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

		// assert
		assertEquals(expected, actual);
	}
}