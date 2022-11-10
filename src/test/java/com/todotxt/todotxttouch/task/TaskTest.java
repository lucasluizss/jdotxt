package com.todotxt.todotxttouch.task;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TaskTest {

    @Test
    public void hiddenTest() {
        String text = "Hidden task h:1";
        Task task = new Task(1, text);
        boolean hidden = task.isHidden();
        assertTrue(hidden);
    }

    @Test
    public void normalTest() {
        String text = "Normal task";
        Task task = new Task(1, text);
        boolean hidden = task.isHidden();
        assertFalse(hidden);
    }

    @Test
    public void testConstructor1() {
        Task task = new Task();
        Task task1 = new Task(task);
        assertNotNull(task1);
    }

    @Test
    public void testConstructor2() {
        Task task2 = new Task(1, "texto");
        assertNotNull(task2);
    }

    @Test
    public void testInitAndUpdate() {
        Task task = new Task();
        task.update("Texto a atualizar");
        assertNotNull(task);
    }

}
