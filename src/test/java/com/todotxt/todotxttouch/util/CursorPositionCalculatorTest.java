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
	public void testReturnsNewValueLengthIfPriorIsNull() {
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

	@Test
	public void testReturnsNewPositionLongerString() {
		// arange
		int expected = 6;
		int priorCursorPosition = 6;
		String priorValue = "Old Value";
		String newValue = "New Value";

		// act
		int actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

		// assert
		assertEquals(expected, actual);
	}

	@Test
	public void testReturnsNewPositionBack() {
		CursorPositionCalculator calculator = new CursorPositionCalculator();
		// arange
		int expected = 0;
		int priorCursorPosition = 1;
		String priorValue = "Old Value";
		String newValue = "New";

		// act
		int actual = CursorPositionCalculator.calculate(priorCursorPosition, priorValue, newValue);

		// assert
		assertEquals(expected, actual);
	}
}
