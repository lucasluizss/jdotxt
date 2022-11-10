package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HiddenFilterTest {

    @Test
    public void testHiddenFilterApplyHidden() {
        HiddenFilter hiddenFilter = new HiddenFilter();

        String name = "Hidden task h:1";
        Task task = new Task(1, name);

        boolean result = hiddenFilter.apply(task);

        assertFalse(result);
    }

    @Test
    public void testHiddenFilterApplyShown() {
        HiddenFilter hiddenFilter = new HiddenFilter();

        String name = "task";
        Task task = new Task(1, name);

        boolean result = hiddenFilter.apply(task);

        assertTrue(result);
    }
}
