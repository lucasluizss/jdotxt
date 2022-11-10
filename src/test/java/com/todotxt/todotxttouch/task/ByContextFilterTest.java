package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ByContextFilterTest {

	@Test
	public void testNewFilterNullContexts() {
		List<String> contexts = null;

		ByContextFilter filter = new ByContextFilter(contexts);

		List<String> expected = new ArrayList<>();
		List<String> actual = filter.getContexts();

		assertEquals(expected, actual);
	}

	@Test
	public void testNewFilterWithContexts() {
		List<String> contexts = Arrays.asList("c1", "c2", "c3");

		ByContextFilter filter = new ByContextFilter(contexts);

		List<String> expected = contexts;
		List<String> actual = filter.getContexts();

		assertEquals(expected, actual);
	}

	/*
	 * ByContextFilter::apply(Task task)
	 */

	@Test
	public void testFilterApply() {
		List<String> contexts = Arrays.asList("c1");

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task(0, "@c1");

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyTaskNoContexts() {
		List<String> contexts = Arrays.asList("c1");

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task();

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoContexts() {
		List<String> contexts = new ArrayList<>();

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task(0, "@c1");

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoMatch() {
		List<String> contexts = Arrays.asList("c1");

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task(0, "@c2");

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyFilterApplyNoMatch() {
		List<String> contexts = Arrays.asList("-");

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task(0, "@c2");

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testEmptyFilterApplyMatch() {
		List<String> contexts = Arrays.asList("-");

		ByContextFilter filter = new ByContextFilter(contexts);

		Task task = new Task();

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}
}
