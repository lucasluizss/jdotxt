package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AndFilterTest {

    @Test
    public void testAddFilterNull() {
        AndFilter andFilter = new AndFilter();

        andFilter.addFilter(null);

        assertEquals(0, andFilter.filters.size());
    }

    @Test
    public void testAddFilter() {
        AndFilter andFilter = new AndFilter();

        Filter<Task> filter = new OrFilter();
        andFilter.addFilter(filter);

        assertEquals(1, andFilter.filters.size());
    }

    @Test
    public void testApplyFilterEmptyFilters() {
        AndFilter andFilter = new AndFilter();
        Task task = new Task(1, "test");

        assertTrue(andFilter.apply(task));
    }

    @Test
    public void testApplyFilter() {
        AndFilter andFilter = new AndFilter();
        Filter<Task> andFilter1 = new AndFilter();
        andFilter.addFilter(andFilter1);
        Task task = new Task(1, "test");

        boolean result = andFilter.apply(task);

        assertTrue(result);
    }
}
