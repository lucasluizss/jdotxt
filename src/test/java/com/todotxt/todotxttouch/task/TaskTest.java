package com.todotxt.todotxttouch.task;

import com.chschmid.jdotxt.gui.JdotxtGUI;
import com.chschmid.jdotxt.util.LanguagesController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskTest {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

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

    @Test
    public void testHasCode() {
        Task task = new Task();
        int hasCode = task.hashCode();
        assertNotNull(hasCode);
    }

    @Test
    public void testEquals() {
        Task task = new Task();
        Task task2 = new Task(1, "texto");
        assertFalse(task.equals(task2));
    }

    @Test
    public void testEquals1() {
        Task task = new Task();
        Task task2 = new Task();
        assertTrue(task.equals(task2));
    }

    @Test
    public void testInitWithFilters() {
        Task task = new Task();
        task.initWithFilters(null, null, null);
        assertNotNull(task);
    }

    @Test
    public void testHasCode1() {
        Task task = new Task(1, "texto");
        int hasCode = task.hashCode();
        assertNotNull(task);
        assertNotNull(hasCode);
    }

    @Test
    public void testInScreenFormat() {
        Task task = new Task(1, "texto");
        String actual = task.inScreenFormat();
        assertNotNull(actual);
    }

    @Test
    public void testInScreenFormatReturnedValue() {
        Task task = new Task(1, "texto");
        String actual = task.inScreenFormat();
        assertEquals("texto", actual);
    }

    @Test
    public void testInScreenFormatCompleted() {
        Task task = new Task(1, "texto");
        task.markComplete(new java.util.Date(100000000));
        String actual = task.inScreenFormat();
        assertEquals("x 1970-01-02 texto", actual);
    }

    @Test
    public void testUpdateTaskt() {
        Task task = new Task(1, "texto");
        task.update("updated");
        assertEquals("updated", task.getText());
    }

    @Test
    public void testNewEmptyTask() {
        Task t = new Task();

        assertEquals(0, t.getAmount());
        assertEquals("", t.getCompletionDate());
        assertEquals(Collections.EMPTY_LIST, t.getContexts());
        assertEquals(0, t.getDuration());
        assertEquals(0, t.getId());
        assertEquals(Collections.EMPTY_LIST, t.getLinks());
        assertEquals(Collections.EMPTY_LIST, t.getMailAddresses());
        assertEquals(Priority.NONE, t.getOriginalPriority());
        assertEquals("", t.getOriginalText());
        assertEquals(Collections.EMPTY_LIST, t.getPhoneNumbers());
        assertEquals("", t.getPrependedDate());
        assertEquals(Priority.NONE, t.getPriority());
        assertEquals(Collections.EMPTY_LIST, t.getProjects());
        assertEquals("", t.getRelativeAge());
        assertEquals("", t.getText());

        assertNull(t.getDueDate());
        assertNull(t.getThresholdDate());

        assertTrue(t.isDeleted());
        assertFalse(t.isCompleted());
        assertFalse(t.isHidden());
        assertFalse(t.isRec());
        assertFalse(t.isFromThreshold());
    }

    @Test
    public void testGetLinks() {
        Task t = new Task(1, "http://www.link.com", new Date(1000000));
        List<URL> urls = t.getLinks();
        assertEquals(1, urls.size());
    }

    @Test
    public void testGetPrependedDate() {
        JdotxtGUI.lang = new LanguagesController("English");
        Task t = new Task(1, "2022-01-01 test", new Date(1000000));
        String prependedDate = t.getPrependedDate();
        assertEquals("2022-01-01", prependedDate);
    }

    @Test
    public void testGetRelativeAge() {
        JdotxtGUI.lang = new LanguagesController("English");
        Task t = new Task(1, "2020-01-01 test", new Date(1000000));
        String relativeAge = t.getRelativeAge();
        assertEquals("2020-01-01", relativeAge);
    }

    @Test
    public void testIsRec() {
        Task t = new Task(1, "rec:+123d", new Date(1000000));
        boolean isRec = t.isRec();
        assertTrue(isRec);
    }

    @Test
    public void testIsFromThreshold() {
        Task t = new Task(1, "rec:+123d", new Date(1000000));
        boolean isFromThreshold = t.isFromThreshold();
        assertTrue(isFromThreshold);
    }

    @Test
    public void testGetDuration() {
        Task t = new Task(1, "rec:+123d", new Date(1000000));
        int duration = t.getDuration();
        assertEquals(6, duration);
    }

    @Test
    public void testGetAmount() {
        Task t = new Task(1, "rec:+123d", new Date(1000000));
        int amount = t.getAmount();
        assertEquals(123, amount);
    }

    @Test
    public void testEqualsNull() {
        Task t = new Task();

        assertFalse(t.equals(null));
    }

    @Test
    public void testEqualsDifferentId() {
        Task t1 = new Task(1, "text");
        Task t2 = new Task(2, "text");

        assertFalse(t1.equals(t2));
    }

    @Test
    public void testEqualsSameTask() {
        Task t = new Task();

        assertTrue(t.equals(t));
    }

    @Test
    public void testCopyInto() {
        Task from = new Task(0, "abc");
        Task into = new Task();

        from.copyInto(into);

        assertEquals(from, into);
    }

    @Test
    public void testMarkComplete() {
        Task t = new Task(0, "(A) abcdef");

        Date now = new Date(0);
        t.markComplete(now);

        assertEquals(Priority.NONE, t.getPriority());
        assertEquals(DATE_FORMAT.format(now), t.getCompletionDate());
        assertFalse(t.isDeleted());
        assertTrue(t.isCompleted());
    }

    @Test
    public void testMarkCompleteAgain() {
        Task t = new Task(0, "(A) abcdef");

        Date now = new Date(0);
        t.markComplete(now);

        now = new Date(0);
        t.markComplete(now);

        assertEquals(Priority.NONE, t.getPriority());
        assertEquals(DATE_FORMAT.format(now), t.getCompletionDate());
        assertFalse(t.isDeleted());
        assertTrue(t.isCompleted());
    }

    @Test
    public void testMarkIncomplete() {
        Task t = new Task(0, "(A) abcdef");

        Date now = new Date(0);
        t.markComplete(now);

        t.markIncomplete();

        assertEquals("", t.getCompletionDate());
        assertFalse(t.isCompleted());
    }

    @Test
    public void testMarkIncompleteAgain() {
        Task t = new Task(0, "(A) abcdef");

        t.markIncomplete();

        assertEquals("", t.getCompletionDate());
        assertFalse(t.isCompleted());
    }

    @Test
    public void testDeleteTask() {
        Task t = new Task(0, "(A) abdc +p @c");

        t.delete();

        assertTrue(t.isDeleted());
    }

    @Test
    public void testInFileFormatHeaderEmptyTask() {
        Task t = new Task();

        assertEquals("", t.inFileFormatHeader());
    }

    @Test
    public void testToStringTask() {
        Task t = new Task(1, "test", new Date(1000000));

        assertEquals("1970-01-01 test", t.toString());
    }

    @Test
    public void testInFileFormatHeaderPriority() {
        Task t = new Task(0, "(A) abdc +p @c");

        assertEquals("(A) ", t.inFileFormatHeader());
    }

    @Test
    public void testInFileFormatHeaderCompleted() {
        Task t = new Task(0, "abdc +p @c");

        Date now = new Date(0);
        t.markComplete(now);

        String expected = "x " + DATE_FORMAT.format(now) + " ";

        assertEquals(expected, t.inFileFormatHeader());
    }

    @Test
    public void testInFileFormatHeaderNoDateEmptyTask() {
        Task t = new Task();

        assertEquals("", t.inFileFormatHeaderNoDate());
    }

    @Test
    public void testInFileFormatHeaderNoDateCompleted() {
        Task t = new Task(0, "abdc +p @c");

        Date now = new Date(0);
        t.markComplete(now);

        String expected = "x " + DATE_FORMAT.format(now) + " ";

        assertEquals(expected, t.inFileFormatHeaderNoDate());
    }

    @Test
    public void getMailAdressesTest() {
        Task t = new Task(0, "alice@mail.com bob@mail.com");

        List<String> expected = Arrays.asList("alice@mail.com", "bob@mail.com");
        List<String> actual = t.getMailAddresses();

        assertEquals(expected, actual);
    }
}
