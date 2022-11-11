package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ByPriorityFilterTest {

	@Test
	public void testCreateFilterEmpty() {
		ByPriorityFilter priorityFilter = new ByPriorityFilter(null);
		assertEquals(0, priorityFilter.getPriorities().size());
	}

	@Test
	public void testNewPriorityFilterNullPriorities() {
		ByPriorityFilter filter = new ByPriorityFilter(null);

		List<Priority> expected = new ArrayList<>();
		List<Priority> actual = filter.getPriorities();

		assertEquals(expected, actual);
	}

	@Test
	public void testApplyZero() {
		List<Priority> priorities = new ArrayList<>();
		ByPriorityFilter priorityFilter = new ByPriorityFilter(priorities);
		Task input = new Task(1, "text");

		boolean returned = priorityFilter.apply(input);
		assertTrue(returned);
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
	public void testApplyContainsPriority() {
		List<Priority> priorities = new ArrayList<>();
		priorities.add(Priority.A);
		ByPriorityFilter priorityFilter = new ByPriorityFilter(priorities);
		Task input = new Task(1, "text");
		input.setPriority(Priority.A);

		boolean returned = priorityFilter.apply(input);
		assertTrue(returned);
	}

	@Test
	public void testApplyNotContainPriority() {
		List<Priority> priorities = new ArrayList<>();
		priorities.add(Priority.A);
		ByPriorityFilter priorityFilter = new ByPriorityFilter(priorities);
		Task input = new Task(1, "text");
		input.setPriority(Priority.B);

		boolean returned = priorityFilter.apply(input);
		assertFalse(returned);
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