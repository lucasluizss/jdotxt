package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskBagFactoryTest {

    @Test
    public void testGetTaskBag() {
        TaskBagFactory taskBagFactory = new TaskBagFactory();
        LocalFileTaskRepository local = new LocalFileTaskRepository();
        JdotxtTaskBagImpl expected = new JdotxtTaskBagImpl(local);

        TaskBag taskBag = TaskBagFactory.getTaskBag();

        assertEquals(expected.getTasks(), taskBag.getTasks());
    }
}
