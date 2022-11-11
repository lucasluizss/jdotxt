package com.todotxt.todotxttouch.task;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TextSplitterTest {

    @ParameterizedTest
    @NullSource
    public void testSplitNull(String text) {
        TextSplitter splitter = TextSplitter.getInstance();
        TextSplitter.SplitResult result = splitter.split(text);

        assertEquals(Priority.NONE, result.priority);
        assertEquals("", result.prependedDate);
        assertEquals("", result.text);
        assertFalse(result.completed);
        assertEquals("", result.completedDate);
    }
}
