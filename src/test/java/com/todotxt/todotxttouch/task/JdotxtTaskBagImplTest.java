package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

	@Test
	public void testStoreTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.store();
		assertNotNull(taskBag);
	}

	@Test
	public void testStoreWithTasks() {
		LocalFileTaskRepository local = new LocalFileTaskRepository();
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(local);
		taskBag.addAsTask("task t +p @c");
		taskBag.addAsTask("task y +p @c");
		taskBag.store();
		assertNotNull(taskBag);
	}

	@Test
	public void testArchiveTask() {
		LocalFileTaskRepository local = new LocalFileTaskRepository();
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(local);
		taskBag.archive();
	}

	@Test(expected = TaskPersistException.class)
	public void testArchiveTaskWithError() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.archive();
	}

	@Test
	public void testUnrchiveTask() {
		LocalFileTaskRepository local = new LocalFileTaskRepository();
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(local);
		Task t = new Task(0, "task t +p @c", new Date());
		taskBag.unarchive(t);
	}

	@Test(expected = TaskPersistException.class)
	public void testUnrchiveTaskWithError() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		Task t = new Task(0, "task t +p @c", new Date());
		taskBag.unarchive(t);
	}

	@Test
	public void testReloadTask() {
		LocalFileTaskRepository local = new LocalFileTaskRepository();
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(local);
		taskBag.reload();
	}

	@Test(expected = NullPointerException.class)
	public void testReloadTaskWithError() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.reload();
	}

	@Test
	public void testClearTask() {
		LocalFileTaskRepository local = new LocalFileTaskRepository();
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(local);
		taskBag.clear();
	}

	@Test(expected = NullPointerException.class)
	public void testClearTaskWithError() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.clear();
	}

	@Test
	public void testSizeTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		int actual = taskBag.size();
		assertEquals(0, actual);
	}

	@Test
	public void testGetPrioritiesTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.addAsTask("task t +p @c");
		taskBag.addAsTask("task y +p @c");
		ArrayList<Priority> priorities = taskBag.getPriorities();
		assertEquals(1, priorities.size());
	}

	@Test
	public void testGetContextTask() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.addAsTask("task t +p @c");
		taskBag.addAsTask("task y +p @c");
		ArrayList<String> priorities = taskBag.getContexts(true);
		assertEquals(2, priorities.size());
	}

	@Test
	public void testTaskHasChanged() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		assertFalse(taskBag.hasChanged());
	}

	@Test
	public void testPushToRemote() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.pushToRemote(true);
		assertNotNull(taskBag);
	}

	@Test
	public void testPushToRemoteOverrided() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.pushToRemote(true, true);
		assertNotNull(taskBag);
	}

	@Test
	public void testPushFromRemote() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.pullFromRemote();
		assertNotNull(taskBag);
	}

	@Test
	public void testPushFromRemoteOverrided() {
		JdotxtTaskBagImpl taskBag = new JdotxtTaskBagImpl(null);
		taskBag.pullFromRemote(true);
		assertNotNull(taskBag);
	}
}
