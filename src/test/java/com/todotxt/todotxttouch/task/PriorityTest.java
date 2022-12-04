package com.todotxt.todotxttouch.task;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityTest {

	@Test
	public void test_range() {
		Priority.range(Priority.A, Priority.H);
		assertTrue(true);
	}

	@Test
	public void testRangeCorrectList() {
		List<Priority> range = Priority.range(Priority.A, Priority.C);
		assertEquals(Priority.A, range.get(0));
		assertEquals(Priority.B, range.get(1));
		assertEquals(Priority.C, range.get(2));
	}

	@Test
	public void testRangeEqualBoundaries() {
		List<Priority> range = Priority.range(Priority.A, Priority.A);
		assertEquals(1, range.size());
		assertEquals(Priority.A, range.get(0));
	}

	@Test
	public void testRangeInCodeCorrectList() {
		List<String> range = Priority.rangeInCode(Priority.A, Priority.C);
		assertEquals("A", range.get(0));
		assertEquals("B", range.get(1));
		assertEquals("C", range.get(2));
	}

	@Test
	public void test_toPriority() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		Priority.toPriority(l);
		assertTrue(true);
	}

	@Test
	public void testToPriorityCorrectList() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		ArrayList<Priority> priorities = Priority.toPriority(l);
		assertEquals(Priority.A, priorities.get(0));
		assertEquals(Priority.B, priorities.get(1));
	}

	@Test
	public void test_toPriority_String() {
		Priority.toPriority("aa");
		assertTrue(true);
	}

	@Test
	public void testToPriorityCorrect() {
		Priority priority = Priority.toPriority("aa");
		assertEquals(Priority.NONE, priority);
	}

	@Test
	public void test_toPriority_null() {
		Priority returned = Priority.toPriority((String) null);
		assertEquals(Priority.NONE, returned);
	}

	@Test
	public void test_range_code() {
		Priority.rangeInCode(Priority.A, Priority.H);
		assertTrue(true);
	}

	@Test
	public void tesInCode() {
		List<Priority> prioritiesList = new ArrayList<>();
		prioritiesList.add(Priority.C);
		prioritiesList.add(Priority.D);

		ArrayList<String> strings = Priority.inCode(prioritiesList);

		assertEquals(2, strings.size());
		assertEquals("C", strings.get(0));
		assertEquals("D", strings.get(1));
	}

	@Test
	public void testInListFormat() {
		String listFormat = Priority.A.inListFormat();
		assertEquals("A", listFormat);
	}

	@Test
	public void testInDetailFormat() {
		String listFormat = Priority.A.inDetailFormat();
		assertEquals("A", listFormat);
	}

}
