package com.todotxt.todotxttouch.task.sorter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.todotxt.todotxttouch.task.Task;

public class SortersTest {

	@Test
	public void testSorterIdAscending() {
		Sorter<Task> sorter = Sorters.ID.ascending();

		Task t0 = new Task(0, "");
		Task t1 = new Task(1, "");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterIdDescending() {
		Sorter<Task> sorter = Sorters.ID.descending();

		Task t0 = new Task(0, "");
		Task t1 = new Task(1, "");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test(expected = NullPointerException.class)
	public void testSorterIdNullT0() {
		Sorter<Task> sorter = Sorters.ID.ascending();

		Task t0 = null;
		Task t1 = new Task(1, "");

		sorter.compare(t0, t1);
	}

	@Test(expected = NullPointerException.class)
	public void testSorterIdNullT1() {
		Sorter<Task> sorter = Sorters.ID.ascending();

		Task t0 = new Task(0, "");
		Task t1 = null;

		sorter.compare(t0, t1);
	}

	@Test
	public void testSorterIdDescending1() {
		Sorter<Task> sorter = Sorters.ID.ascending();

		Task t0 = new Task(10, "");
		Task t1 = new Task(11, "");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterPriorityAscending() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Task t0 = new Task(0, "(A) ");
		Task t1 = new Task(1, "(B) ");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterPriorityDescending() {
		Sorter<Task> sorter = Sorters.PRIORITY.descending();

		Task t0 = new Task(0, "(A) ");
		Task t1 = new Task(1, "(B) ");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterPriorityAscendingBothCompleted() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "(A) ");
		t0.markComplete(now);
		Task t1 = new Task(1, "(B) ");
		t1.markComplete(now);

		assertEquals(0, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterPriorityAscendingOneCompleted() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "(A) ");
		t0.markComplete(now);
		Task t1 = new Task(1, "(B) ");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterPriorityAscendingOtherCompleted() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "(A) ");
		Task t1 = new Task(1, "(B) ");
		t1.markComplete(now);

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test(expected = NullPointerException.class)
	public void testSorterPriorityNullT0() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Task t0 = null;
		Task t1 = new Task(1, "");

		sorter.compare(t0, t1);
	}

	@Test(expected = NullPointerException.class)
	public void testSorterPriorityNullT1() {
		Sorter<Task> sorter = Sorters.PRIORITY.ascending();

		Task t0 = new Task(0, "");
		Task t1 = null;

		sorter.compare(t0, t1);
	}

	@Test
	public void testSorterTextAscending() {
		Sorter<Task> sorter = Sorters.TEXT.ascending();

		Task t0 = new Task(0, "abc");
		Task t1 = new Task(1, "bcd");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterTextDescending() {
		Sorter<Task> sorter = Sorters.TEXT.descending();

		Task t0 = new Task(0, "abc");
		Task t1 = new Task(1, "bcd");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test(expected = NullPointerException.class)
	public void testSorterTextNullT0() {
		Sorter<Task> sorter = Sorters.TEXT.ascending();

		Task t0 = null;
		Task t1 = new Task(1, "");

		sorter.compare(t0, t1);
	}

	@Test(expected = NullPointerException.class)
	public void testSorterTextNullT1() {
		Sorter<Task> sorter = Sorters.TEXT.ascending();

		Task t0 = new Task(0, "");
		Task t1 = null;

		sorter.compare(t0, t1);
	}

	@Test
	public void testSorterDate() {
		Sorter<Task> sorter = Sorters.DATE.ascending();

		Task t0 = new Task(0, "");
		Task t1 = new Task(1, "");

		assertEquals(0, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterCompletionDate() {
		Sorter<Task> sorter = Sorters.COMPLETION_DATE.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "");
		t0.markComplete(now);

		Task t1 = new Task(1, "");
		t1.markComplete(now);

		assertEquals(0, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterProjectsAscending() {
		Sorter<Task> sorter = Sorters.PROJECTS.ascending();

		Task t0 = new Task(0, "+a");
		Task t1 = new Task(1, "+a +b");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterProjectsDescending() {
		Sorter<Task> sorter = Sorters.PROJECTS.descending();

		Task t0 = new Task(0, "+a");
		Task t1 = new Task(1, "+a +b");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterContextsAscending() {
		Sorter<Task> sorter = Sorters.CONTEXTS.ascending();

		Task t0 = new Task(0, "@a");
		Task t1 = new Task(1, "@a");

		assertEquals(0, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterContextsDescending() {
		Sorter<Task> sorter = Sorters.CONTEXTS.descending();

		Task t0 = new Task(0, "@a");
		Task t1 = new Task(1, "@a @b");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterThresholdDateAscending() {
		Sorter<Task> sorter = Sorters.THRESHOLD_DATE.ascending();

		Task t0 = new Task(0, "t:2020-01-01");

		Task t1 = new Task(1, "t:2021-01-01");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterThresholdDateDescending() {
		Sorter<Task> sorter = Sorters.THRESHOLD_DATE.descending();

		Task t0 = new Task(0, "t:2020-01-01");

		Task t1 = new Task(1, "t:2021-01-01");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterCompletionAscending() {
		Sorter<Task> sorter = Sorters.COMPLETION.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "");

		Task t1 = new Task(1, "");
		t1.markComplete(now);

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterCompletionDescending() {
		Sorter<Task> sorter = Sorters.COMPLETION.descending();

		Date now = new Date();

		Task t0 = new Task(0, "");

		Task t1 = new Task(1, "");
		t1.markComplete(now);

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test(expected = NullPointerException.class)
	public void testSorterCompletionNullT0() {
		Sorter<Task> sorter = Sorters.COMPLETION.ascending();

		Task t0 = null;
		Task t1 = new Task(1, "");

		sorter.compare(t0, t1);
	}

	@Test(expected = NullPointerException.class)
	public void testSorterCompletionNullT1() {
		Sorter<Task> sorter = Sorters.COMPLETION.ascending();

		Task t0 = new Task(0, "");
		Task t1 = null;

		sorter.compare(t0, t1);
	}

	@Test
	public void testSorterCompletionAscendingT0Complete() {
		Sorter<Task> sorter = Sorters.COMPLETION.ascending();

		Date now = new Date();

		Task t0 = new Task(0, "");
		t0.markComplete(now);

		Task t1 = new Task(1, "");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterCompletionBothIncomplete() {
		Sorter<Task> sorter = Sorters.COMPLETION.ascending();

		Task t0 = new Task(0, "");
		Task t1 = new Task(1, "");

		assertEquals(0, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterDueDateAscending() {
		Sorter<Task> sorter = Sorters.DUE_DATE.ascending();

		Task t0 = new Task(0, "due:2020-01-01");

		Task t1 = new Task(1, "due:2021-01-01");

		assertEquals(-1, sorter.compare(t0, t1));
	}

	@Test
	public void testSorterDueDateDescending() {
		Sorter<Task> sorter = Sorters.DUE_DATE.descending();

		Task t0 = new Task(0, "due:2020-01-01");

		Task t1 = new Task(1, "due:2021-01-01");

		assertEquals(1, sorter.compare(t0, t1));
	}

	@Test
	public void testCompareDatesBothNull() {
		Date d1 = null;
		Date d2 = null;

		assertEquals(0, Sorters.compareDates(d1, d2, false));
	}

	@Test
	public void testCompareDatesD1Null() {
		Date d1 = null;
		Date d2 = new Date();

		assertEquals(-1, Sorters.compareDates(d1, d2, false));
	}

	@Test
	public void testCompareDatesD2Null() {
		Date d1 = new Date();
		Date d2 = null;

		assertEquals(1, Sorters.compareDates(d1, d2, false));
	}

	@Test
	public void testCompareList() {
		List<String> l1 = Arrays.asList(null, "B", "C");
		List<String> l2 = Arrays.asList(null, null, "F");

		assertEquals(1, Sorters.compareLists(l1, l2));
	}

	@Test
	public void testCompareList1() {
		List<String> l1 = Arrays.asList(null, null, "A");
		List<String> l2 = Arrays.asList(null, null);

		assertEquals(1, Sorters.compareLists(l1, l2));
	}

	@Test
	public void testCompareList2() {
		List<String> l1 = Arrays.asList("A", "B");
		List<String> l2 = Arrays.asList("A", "B");

		assertEquals(0, Sorters.compareLists(l1, l2));
	}

	@Test
	public void testCompareList3() {
		List<String> l1 = Arrays.asList("A", "B", "C");
		List<String> l2 = Arrays.asList("D", "E", "F");

		assertEquals(-3, Sorters.compareLists(l1, l2));
	}

	@Test
	public void testCompareList4() {
		List<String> l1 = Arrays.asList(null, "B", "C");
		List<String> l2 = Arrays.asList("D", "E", "F");

		assertEquals(-1, Sorters.compareLists(l1, l2));
	}

	@Test
	public void testgetName1() {
		Sorters t = Sorters.TEXT;
		String expected = "Task Text";

		assertEquals(expected, t.getName());
	}
}
