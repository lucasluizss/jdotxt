package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ByPriorityFilterTest {

    @Test
    public void testCreateFilterEmpty() {
        ByPriorityFilter priorityFilter = new ByPriorityFilter(null);
        assertEquals(0, priorityFilter.getPriorities().size());
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
}
