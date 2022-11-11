package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.chschmid.jdotxt.Jdotxt;
import com.chschmid.jdotxt.gui.JdotxtGUI;
import com.chschmid.jdotxt.util.LanguagesController;
import com.todotxt.todotxttouch.task.sorter.Sorters;

public class TaskBagImplTest {

	private ArrayList<Task> savedtodotasks;
	private ArrayList<Task> saveddonetasks;
	private LocalFileTaskRepository savedRepo;
	private TaskBagImpl bag;

	@Before
	public void setUp() throws Exception {

		Preferences userPrefs = Preferences.userNodeForPackage(Jdotxt.class);
		JdotxtGUI.lang = new LanguagesController(userPrefs.get("lang", "English"));

		savedRepo = new LocalFileTaskRepository();
		savedtodotasks = savedRepo.load();
		saveddonetasks = savedRepo.loadDoneTasks();
		savedRepo.purge();
		bag = new TaskBagImpl(new LocalFileTaskRepository());
		bag.clear();
	}

	@After
	public void tearDown() throws Exception {
		savedRepo.store(savedtodotasks);
		savedRepo.storeDoneTasks(saveddonetasks);
	}

	@Test
	public void testBagAddAsTask() {
		List<Task> expected = new ArrayList<>();
		expected.add(new Task(0, "Task0", new Date()));
		expected.add(new Task(1, "Task1", new Date()));
		expected.add(new Task(2, "Task2", new Date()));

		bag.addAsTask(expected.get(0).inFileFormat());
		bag.addAsTask(expected.get(1).inFileFormat());
		bag.addAsTask(expected.get(2).inFileFormat());
		List<Task> actual = bag.getTasks();
		assertEquals(expected, actual);
		bag.clear();
	}

	@Test
	public void testBagUpdate1() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();

		Task expected = new Task(1, "Task1", dt);

		bag.update(expected);
		List<Task> updatedTasks = bag.getTasks();

		assertEquals(expected, updatedTasks.get(1));
	}

	@Test(expected = TaskPersistException.class)
	public void testBagUpdate2() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		bag.update(null);

		assertEquals(tasks, bag.getTasks());
	}

	@Test(expected = TaskPersistException.class)
	public void testBagUpdate3() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		Task updatedTask = new Task(3, "voidTask", new Date());
		bag.update(updatedTask);
	}

	@Test
	public void testBagDelete1() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		Task toRemove = tasks.get(1);
		bag.delete(toRemove);
		tasks.remove(toRemove);

		assertEquals(tasks, bag.getTasks());
	}

	@Test(expected = TaskPersistException.class)
	public void testBagDelete2() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		Task toRemove = new Task(3, "voidTask", new Date());
		bag.delete(toRemove);
	}

	@Test
	public void testBagGetPriorities() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		tasks.get(0).setPriority(Priority.A);
		tasks.get(1).setPriority(Priority.D);
		tasks.get(2).setPriority(Priority.E);

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		ArrayList<Priority> expected = new ArrayList<>();
		expected.add(Priority.A);
		expected.add(Priority.D);
		expected.add(Priority.E);

		assertEquals(expected, bag.getPriorities());
	}

	@Test
	public void testBagGetContexts1() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "someTask @Cont1 @Cont2", new Date()));
		tasks.add(new Task(1, "anyTask @Cont3", new Date()));
		tasks.add(new Task(2, "noTask @Cont4", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		ArrayList<String> expected = new ArrayList<>();
		expected.add("Cont1");
		expected.add("Cont2");
		expected.add("Cont3");
		expected.add("Cont4");
		assertEquals(expected, bag.getContexts(false));
	}

	@Test
	public void testBagGetContexts2() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "someTask @Cont1 @Cont2", new Date()));
		tasks.add(new Task(1, "anyTask @Cont3", new Date()));
		tasks.add(new Task(2, "noTask @Cont4", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		ArrayList<String> expected = new ArrayList<>();
		expected.add("-");
		expected.add("Cont1");
		expected.add("Cont2");
		expected.add("Cont3");
		expected.add("Cont4");
		assertEquals(expected, bag.getContexts(true));
	}

	@Test
	public void testBagGetProjects1() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "someTask @Cont1 @Cont2 +Proj1", new Date()));
		tasks.add(new Task(1, "anyTask @Cont3 +Proj2", new Date()));
		tasks.add(new Task(2, "noTask @Cont4 +Proj3 +Proj4", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		ArrayList<String> expected = new ArrayList<>();
		expected.add("Proj1");
		expected.add("Proj2");
		expected.add("Proj3");
		expected.add("Proj4");
		assertEquals(expected, bag.getProjects(false));
	}

	@Test
	public void testBagGetProjects2() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "someTask @Cont1 @Cont2 +Proj1", new Date()));
		tasks.add(new Task(1, "anyTask @Cont3 +Proj2", new Date()));
		tasks.add(new Task(2, "noTask @Cont4 +Proj3 +Proj4", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		ArrayList<String> expected = new ArrayList<>();
		expected.add("-");
		expected.add("Proj1");
		expected.add("Proj2");
		expected.add("Proj3");
		expected.add("Proj4");
		assertEquals(expected, bag.getProjects(true));
	}

	@Test
	public void testBagSize() {
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task(0, "Task0", new Date()));
		tasks.add(new Task(1, "Task1", new Date()));
		tasks.add(new Task(2, "Task2", new Date()));

		for (Task t : tasks) {
			bag.addAsTask(t.inFileFormat());
		}

		assertEquals(3, bag.size());
	}

	@Test
	public void testBagStore() {
		List<Task> expected = new ArrayList<>();
		expected.add(new Task(0, "Task0", new Date()));
		expected.add(new Task(1, "Task1", new Date()));
		expected.add(new Task(2, "Task2", new Date()));

		for (Task t : expected)
			bag.addAsTask(t.inFileFormat());

		bag.store();
		bag.reload();

		List<Task> actual = bag.getTasks();

		assertEquals(expected, actual);
		bag.clear();
	}

	@Test
	public void testBagArchive1() {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t2.markComplete(new Date());

		expected.add(t1);
		expected.add(t3);

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		bag.archive();
		bag.reload();
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));
		bag.clear();
	}

	@Test
	public void testBagArchive2() {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t1.markComplete(new Date());
		t2.markComplete(new Date());

		expected.add(t3);
		expected.add(t1);

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		bag.archive();
		bag.unarchive(t1);
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));
		bag.clear();
	}

	@Test
	public void testBagArchive3() {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t1.markComplete(new Date());
		t2.markComplete(new Date());

		expected.add(t1);
		expected.add(t3);

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		bag.archive();
		bag.unarchive(new Task(-1, "Task0", new Date()));
		t1.markIncomplete();
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));
		bag.clear();
	}

	@Test
	public void testBagArchive4() {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t2.markComplete(new Date());
		t3.markComplete(new Date());

		expected.add(t1);
		expected.add(t3);

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		bag.archive();
		bag.unarchive(new Task(5, "Task2", new Date()));
		t3.markIncomplete();
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));
		bag.clear();
	}

	@Test
	public void testBagArchive5() throws ParseException {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t1.markComplete(new Date());
		t2.markComplete(new Date());

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		Task tn = new Task(1, "moreTask", getMockDate("2000-01-01"));

		bag.archive();
		bag.unarchive(tn);
		expected.add(t3);
		expected.add(tn);
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));

		bag.clear();
	}

	@Test
	public void testBagArchive6() throws ParseException {
		ArrayList<Task> expected = new ArrayList<>();
		Task t1 = new Task(0, "Task0", new Date());
		Task t2 = new Task(1, "Task1", new Date());
		Task t3 = new Task(2, "Task2", new Date());

		t1.markComplete(new Date());
		t2.markComplete(new Date());

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());

		Task tn = new Task(0, "moreTask", getMockDate("2000-01-01"));

		bag.archive();
		bag.unarchive(tn);
		expected.add(tn);
		expected.add(t3);
		List<Task> actual = bag.getTasks();
		assertTrue(areEqual(expected, actual));

		bag.clear();
	}

	private boolean areEqual(ArrayList<Task> expected, List<Task> actual) {
		if (expected.size() != actual.size())
			return false;
		if (expected == null || actual == null)
			return false;

		for (int i = 0; i < actual.size(); i++) {
			if (!expected.get(i).inFileFormat().equals(actual.get(i).inFileFormat()))
				return false;
		}

		return true;
	}

	@Test
	public void testBagFilter1() {
		Task t1 = new Task(0, "t1", new Date());
		Task t2 = new Task(1, "t2", new Date());
		Task t3 = new Task(2, "t3", new Date());
		Task t4 = new Task(3, "t4", new Date());
		Task t5 = new Task(4, "t5", new Date());
		Task t6 = new Task(5, "t6", new Date());

		t1.setPriority(Priority.B);
		t2.setPriority(Priority.A);
		t3.setPriority(Priority.A);
		t4.setPriority(Priority.E);
		t5.setPriority(Priority.C);
		t6.setPriority(Priority.F);

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());
		bag.addAsTask(t4.inFileFormat());
		bag.addAsTask(t5.inFileFormat());
		bag.addAsTask(t6.inFileFormat());

		List<Priority> priorities = new ArrayList<>();
		priorities.add(Priority.A);

		List<Task> expected = new ArrayList<>();
		expected.add(t2);
		expected.add(t3);

		List<Task> actual = bag.getTasks(FilterFactory.generateAndFilter(priorities, new ArrayList<String>(),
				new ArrayList<String>(), null, false, true, true), null);

		assertEquals(expected, actual);
		bag.clear();
	}

	@Test
	public void testBagFilter2() {
		Task t1 = new Task(0, "t1 @Cont1", new Date());
		Task t2 = new Task(1, "t2 @Cont2", new Date());
		Task t3 = new Task(2, "t3 @Cont1", new Date());
		Task t4 = new Task(3, "t4 @Cont1 @Cont2", new Date());
		Task t5 = new Task(4, "t5 @Cont3", new Date());
		Task t6 = new Task(5, "t6 @Cont4", new Date());

		bag.addAsTask(t1.inFileFormat());
		bag.addAsTask(t2.inFileFormat());
		bag.addAsTask(t3.inFileFormat());
		bag.addAsTask(t4.inFileFormat());
		bag.addAsTask(t5.inFileFormat());
		bag.addAsTask(t6.inFileFormat());

		List<String> contexts = new ArrayList<>();
		contexts.add("Cont1");

		List<Task> expected = new ArrayList<>();
		expected.add(t1);
		expected.add(t3);
		expected.add(t4);

		List<Task> actual = bag.getTasks(FilterFactory.generateAndFilter(new ArrayList<Priority>(), contexts,
				new ArrayList<String>(), null, false, true, true), Sorters.ID.ascending());

		assertEquals(expected, actual);
		bag.clear();
	}

	private Date getMockDate(String date) throws ParseException {
		return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	}
}
