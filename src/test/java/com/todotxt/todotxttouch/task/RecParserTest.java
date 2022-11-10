package com.todotxt.todotxttouch.task;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecParserTest {

    @Test
    public void testRecParser() {
        RecParser recParser = RecParser.getInstance();
        String text = "rec:+2d";
        String[] recs = recParser.parse(text);

        assertEquals("+", recs[0]);
        assertEquals("2", recs[1]);
        assertEquals("d", recs[2]);
    }
}
