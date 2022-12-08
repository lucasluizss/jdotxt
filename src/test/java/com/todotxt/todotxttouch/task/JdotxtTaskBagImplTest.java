package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.chschmid.jdotxt.gui.JdotxtGUI;

public class JdotxtTaskBagImplTest {

	@Before
	public void setup() {
		JdotxtGUI.loadLookAndFeel("English");
	}

	@Test
	public void testNewJdotxtTaskBagNullRepo() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		assertEquals(0, taskBag.size());
		assertEquals(Collections.EMPTY_LIST, taskBag.getTasks());
		assertEquals(Collections.EMPTY_LIST, taskBag.getContexts(false));
		assertEquals(Collections.EMPTY_LIST, taskBag.getPriorities());
		assertEquals(Collections.EMPTY_LIST, taskBag.getProjects(false));
	}

	@Test
	public void testAddAsTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		taskBag.addAsTask("task t +p @c");

		List<Task> actual = taskBag.getTasks();
		List<Task> expected = Arrays.asList(new Task(0, "task t +p @c", new Date()));

		assertEquals(expected, actual);
	}

	@Test
	public void testAddAsTaskCheckReturned() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task task = taskBag.addAsTask("task t +p @c");

		assertEquals("task t +p @c", task.getText());
	}

	@Test
	public void testUpdateTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task t = new Task(0, "task t +p @c", new Date());

		taskBag.addAsTask("task t +p @c");
		taskBag.update(t);

		List<Task> actual = taskBag.getTasks();

		assertNotNull(actual);
	}

	@Test
	public void testUpdateFindTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		taskBag.addAsTask("task t +p @c");

		Task t = taskBag.getTasks().get(0);

		taskBag.update(t);

		List<Task> actual = taskBag.getTasks();

		assertNotNull(actual);
	}

	@Test(expected = TaskPersistException.class)
	public void testUpdateTaskNotFound() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task t = new Task(0, "task t +p @c", new Date());

		taskBag.update(t);
	}

	@Test
	public void testUpdateNullTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task t = null;
		taskBag.update(t);

		assertNull(t);
	}

	@Test
	public void testDeleteTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task t = new Task(0, "task t +p @c", new Date());

		taskBag.addAsTask("task t +p @c");
		taskBag.delete(t);

		List<Task> actual = taskBag.getTasks();
		List<Task> expected = new ArrayList<>();

		assertEquals(expected, actual);
	}

	@Test(expected = TaskPersistException.class)
	public void testDeleteTaskNotFound() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);

		Task t = new Task(0, "task t +p @c", new Date());

		taskBag.delete(t);
	}
}
