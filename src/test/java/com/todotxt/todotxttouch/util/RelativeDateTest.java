package com.todotxt.todotxttouch.util;

import com.chschmid.jdotxt.gui.JdotxtGUI;
import com.chschmid.jdotxt.util.LanguagesController;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static org.junit.Assert.assertEquals;

public class RelativeDateTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private static final long SECOND = 1000; //milliseconds
    private static final long HOUR = 3600 * SECOND;
    private static final long DAY = 24 * HOUR;
    private static final long YEAR = 365 * DAY;

    @Test
    public void getRelativeDateE1() {
        // arrange
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 4);
        String expected = sdf.format(d2.getTime());

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE2Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        String expected = "today";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE2() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.set(Calendar.HOUR_OF_DAY, 22);
        String expected = "today";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE3Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_MONTH, 1);
        String expected = "1 day ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE3() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_MONTH, 1);
        d1.add(Calendar.HOUR_OF_DAY, 22);
        String expected = "1 day ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE4Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_MONTH, 2);
        String expected = "2 days ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE4() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 29);
        String expected = "29 days ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE5Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 30);
        String expected = "1 month ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE5() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 59);
        String expected = "1 month ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE6Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 60);
        String expected = "2 months ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE6() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.DAY_OF_YEAR, 30 * 11);
        String expected = "11 months ago";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }

    @Test
    public void getRelativeDateE7Boundary() {
        // arrange
        JdotxtGUI.lang = new LanguagesController("English");
        Calendar d2 = new GregorianCalendar(2015, 0, 5);
        Calendar d1 = new GregorianCalendar(2015, 0, 5);
        d1.add(Calendar.YEAR, 1);
        String expected = "2015-01-05";

        // act
        String result = RelativeDate.getRelativeDate(d1, d2);

        // assert
        assertEquals(expected, result);
    }
}
