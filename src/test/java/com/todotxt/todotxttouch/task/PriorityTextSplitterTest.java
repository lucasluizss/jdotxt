package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityTextSplitterTest {

    @Test
    public void testSplitNull() {
        PriorityTextSplitter.PrioritySplitResult result = PriorityTextSplitter.getInstance().split(null);
        assertEquals(Priority.NONE, result.priority);
        assertEquals("", result.text);
    }

}
