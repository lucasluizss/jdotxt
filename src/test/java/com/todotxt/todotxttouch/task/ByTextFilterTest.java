package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ByTextFilterTest {

	@Test
	public void testNewFilter() {
		ByTextFilter filter = new ByTextFilter("filter", true);

		String expected = "filter";
		String actual = filter.getText();

		assertEquals(expected, actual);
		assertTrue(filter.isCaseSensitive());
	}

	@Test
	public void testNewFilterNullText() {
		ByTextFilter filter = new ByTextFilter(null, false);

		String expected = "";
		String actual = filter.getText();

		assertEquals(expected, actual);
		assertFalse(filter.isCaseSensitive());
	}

	@Test
	public void testNewFilterNotCaseSensitive() {
		ByTextFilter filter = new ByTextFilter("filter", false);

		String expected = "filter".toUpperCase();
		String actual = filter.getText();

		assertEquals(expected, actual);
		assertFalse(filter.isCaseSensitive());
	}

	@Test
	public void testFilterApply() {
		Task task = new Task(0, "task abc");

		ByTextFilter filter = new ByTextFilter("abc", false);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyCaseSensitive() {
		Task task = new Task(0, "task abc");

		ByTextFilter filter = new ByTextFilter("abc", true);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoMatch() {
		Task task = new Task(0, "task abc");

		ByTextFilter filter = new ByTextFilter("def", true);

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyEmptyText() {
		Task task = new Task(0, "abc");

		ByTextFilter filter = new ByTextFilter("", false);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}
}