package com.todotxt.todotxttouch.task;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PriorityTextSplitterTest {

    private String task;
    private Set<String> expected;
    private Set<String> actual;

    //public PriorityTextSplitter instance = mock(PriorityTextSplitter.class);

    @Before
    @BeforeEach
    public void setUp() {
        task = null;
        expected = new HashSet<String>();
        actual = new HashSet<String>();
    }

    @Test
    public void splitTestWithPriority() {
        String input = "(A) 2022-11-06 teste";
        expected.add("A");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @Test
    public void splitTestWithPriorityWithoutText() {
        String input = "(A) 2022-11-06";
        expected.add("A");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @Test
    /*Talvez meter este como suposto "A" e dizer que da mal?*/
    public void splitTestWithPriorityWithoutTextOrDate() {
        String input = "(A)";
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @Test
    public void splitTestWithoutPriority() {
        String input = "2022-11-06 teste";
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @Test
    public void splitTestWithoutPriorityWithoutText() {
        String input = "2022-11-06";
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @Test
    public void splitTestEmptyTask() {
        String input = "";
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(A) 2022-11-06 teste", // task with complete info
            "(A) 2022-11-06", // task without title
            "(A) teste", // task without date
    })
    public void splitWithPriorityTest(String input) {
        expected.add("A");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "2022-11-06 teste", // task without priority
            "2022-11-06", // task without priority and title
            "teste", // task without priority and date
    })
    public void splitWithoutPriorityTest(String input) {
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(A)", // task only with priority
            "", // empty
    })
    public void splitInsuficientInfoTest(String input) {
        expected.add("-");
        actual.add(PriorityTextSplitter.getInstance().split(input).priority.getCode());
        assertEquals(expected, actual);
    }
}