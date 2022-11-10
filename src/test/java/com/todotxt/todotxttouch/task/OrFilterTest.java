package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrFilterTest {

    @Test
    public void testAddFilterNull() {
        OrFilter orFilter = new OrFilter();

        orFilter.addFilter(null);

        assertEquals(0, orFilter.filters.size());
    }

    @Test
    public void testAddFilter() {
        OrFilter orFilter = new OrFilter();

        Filter<Task> filter = new OrFilter();
        orFilter.addFilter(filter);

        assertEquals(1, orFilter.filters.size());
    }

    @Test
    public void testApplyFilterEmptyFilters() {
        OrFilter orFilter = new OrFilter();
        Task task = new Task(1, "test");

        assertTrue(orFilter.apply(task));
    }

    @Test
    public void testApplyFilter() {
        OrFilter orFilter = new OrFilter();
        Filter<Task> orFilter1 = new OrFilter();
        orFilter.addFilter(orFilter1);
        Task task = new Task(1, "test");

        boolean result = orFilter.apply(task);

        assertTrue(result);
    }

    @Test
    public void testApplyFilterFalse() {
        OrFilter orFilter = new OrFilter();
        Filter<Task> hidden = new HiddenFilter();
        orFilter.addFilter(hidden);
        Task task = new Task(1, "Hidden task h:1");

        boolean result = orFilter.apply(task);

        assertFalse(result);
    }
}
