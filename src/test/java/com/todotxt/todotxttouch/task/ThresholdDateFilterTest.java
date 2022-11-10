package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ThresholdDateFilterTest {

    @Test
    public void testApplyNull() {
        ThresholdDateFilter filter = new ThresholdDateFilter();
        Task task = new Task(1, "test");
        assertTrue(filter.apply(task));
    }

    @Test
    public void testApply() {
        ThresholdDateFilter filter = new ThresholdDateFilter();
        Task task = new Task(1, "test t:2018-01-01");
        assertTrue(filter.apply(task));
    }
}
