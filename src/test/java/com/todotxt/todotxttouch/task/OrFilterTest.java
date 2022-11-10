package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class OrFilterTest {

	@Test
	public void emptyFilterTest() {
		OrFilter filter = new OrFilter();

		Task t = new Task();

		assertTrue(filter.apply(t));
	}

	@Test
	public void oneFilterTrueTest() {
		OrFilter filter = new OrFilter();
		ByContextFilter contextFilter = new ByContextFilter(Arrays.asList("context"));
		filter.addFilter(contextFilter);

		Task t = new Task(0, "@context");

		assertTrue(filter.apply(t));
	}

	@Test
	public void oneFilterFalseTest() {
		OrFilter filter = new OrFilter();
		ByContextFilter contextFilter = new ByContextFilter(Arrays.asList("context"));
		filter.addFilter(contextFilter);

		Task t = new Task(0, "@other");

		assertFalse(filter.apply(t));
	}

}