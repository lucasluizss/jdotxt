package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class FilterFactoryTest {

	@Test
	public void generateAndFilterWithPrioritiesTrueTest() {
		List<Priority> priorities = Arrays.asList(Priority.A);

		Filter<Task> filter = FilterFactory.generateAndFilter(priorities,
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "(A) task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterWithPrioritiesFalseTest() {
		List<Priority> priorities = Arrays.asList(Priority.B);

		Filter<Task> filter = FilterFactory.generateAndFilter(priorities,
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "(A) task");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterWithContextsTrueTest() {
		List<String> contexts = Arrays.asList("A");

		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				contexts,
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "@A task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterWithContextsFalseTest() {
		List<String> contexts = Arrays.asList("B");

		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				contexts,
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "@A task");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterWithProjectsTrueTest() {
		List<String> projects = Arrays.asList("A");

		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				projects,
				null,
				false,
				false,
				false);

		Task t = new Task(0, "+A task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterWithProjectsFalseTest() {
		List<String> projects = Arrays.asList("B");

		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				projects,
				null,
				false,
				false,
				false);

		Task t = new Task(0, "+A task");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterWithTextTrueTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				"task",
				false,
				false,
				false);

		Task t = new Task(0, "+A task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterWithTextFalseTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				"task",
				false,
				false,
				false);

		Task t = new Task(0, "+A something");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterCaseSensitiveTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				"TASK",
				false,
				false,
				false);

		Task t = new Task(0, "task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterNonCaseSensitiveTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				"TASK",
				true,
				false,
				false);

		Task t = new Task(0, "task");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterWithHiddenTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				true,
				false);

		Task t = new Task(0, "h:1 task");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterWithoutHiddenTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "h:1 task");

		assertFalse(filter.apply(t));
	}

	// =====

	@Test
	public void generateAndFilterThresholdTrueTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				false,
				true);

		Task t = new Task(0, "Task t:2030-01-01");

		assertTrue(filter.apply(t));
	}

	@Test
	public void generateAndFilterThresholdFalseTest() {
		Filter<Task> filter = FilterFactory.generateAndFilter(Collections.emptyList(),
				Collections.emptyList(),
				Collections.emptyList(),
				null,
				false,
				false,
				false);

		Task t = new Task(0, "Task t:2030-01-01");

		assertFalse(filter.apply(t));
	}
}