package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LinkParserTest {

    @Test
    public void testParseNull() {
        LinkParser linkParser = LinkParser.getInstance();

        assertEquals(Collections.emptyList(), linkParser.parse(null));
    }

    @Test
    public void testParse() {
        LinkParser linkParser = LinkParser.getInstance();
        String text = "http://www.link.com";

        assertEquals(1, linkParser.parse(text).size());
    }
}
