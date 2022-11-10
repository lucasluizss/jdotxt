package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ByPriorityFilterTest {

	@Test
	public void testNewPriorityFilterNullPriorities() {
		ByPriorityFilter filter = new ByPriorityFilter(null);

		List<Priority> expected = new ArrayList<>();
		List<Priority> actual = filter.getPriorities();

		assertEquals(expected, actual);
	}

	@Test
	public void testNewPriorityFilterWithPriorities() {
		List<Priority> priorities = Arrays.asList(Priority.A, Priority.B);

		ByPriorityFilter filter = new ByPriorityFilter(priorities);

		List<Priority> expected = priorities;
		List<Priority> actual = filter.getPriorities();

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApply() {
		Task task = new Task(0, "(A) task");

		List<Priority> priorities = Arrays.asList(Priority.A);

		ByPriorityFilter filter = new ByPriorityFilter(priorities);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoPriorities() {
		Task task = new Task(0, "(A) task");

		List<Priority> priorities = new ArrayList<>();

		ByPriorityFilter filter = new ByPriorityFilter(priorities);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyTaskNoPriority() {
		Task task = new Task(0, "task");

		List<Priority> priorities = Arrays.asList(Priority.A);

		ByPriorityFilter filter = new ByPriorityFilter(priorities);

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}
}