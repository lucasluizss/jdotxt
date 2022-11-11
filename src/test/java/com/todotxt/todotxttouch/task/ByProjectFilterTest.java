package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ByProjectFilterTest {

	@Test
	public void testNewFilterNullProjects() {
		ByProjectFilter filter = new ByProjectFilter(null);

		List<String> expected = new ArrayList<>();
		List<String> actual = filter.getProjects();

		assertEquals(expected, actual);
	}

	@Test
	public void testNewFilterWithProjects() {
		List<String> projects = Arrays.asList("P1", "P2");

		ByProjectFilter filter = new ByProjectFilter(projects);

		List<String> expected = projects;
		List<String> actual = filter.getProjects();

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApply() {
		Task task = new Task(0, "+P1");

		List<String> projects = Arrays.asList("P1");

		ByProjectFilter filter = new ByProjectFilter(projects);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoProjects() {
		Task task = new Task(0, "+P1");

		List<String> projects = Arrays.asList();

		ByProjectFilter filter = new ByProjectFilter(projects);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoMatch() {
		Task task = new Task(0, "task");

		List<String> projects = Arrays.asList("P1");

		ByProjectFilter filter = new ByProjectFilter(projects);

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyTaskDifferentProject() {
		Task task = new Task(0, "task +P2");

		List<String> projects = Arrays.asList("P1");

		ByProjectFilter filter = new ByProjectFilter(projects);

		boolean expected = false;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}

	@Test
	public void testFilterApplyNoPriority() {
		Task task = new Task(0, "task");

		List<String> projects = Arrays.asList("-");

		ByProjectFilter filter = new ByProjectFilter(projects);

		boolean expected = true;
		boolean actual = filter.apply(task);

		assertEquals(expected, actual);
	}
}