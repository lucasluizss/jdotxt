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
	public void test_toPriority() {
		ArrayList<String> l = new ArrayList<String>();
		l.add("a");
		l.add("b");
		Priority.toPriority(l);
		assertTrue(true);
	}

	@Test
	public void test_toPriority_String() {
		Priority.toPriority("aa");
		assertTrue(true);
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
