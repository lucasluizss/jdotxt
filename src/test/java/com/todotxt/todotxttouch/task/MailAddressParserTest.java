package com.todotxt.todotxttouch.task;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MailAddressParserTest {

    @Test
    public void testMailAddressParserNull() {
        List<String> array = MailAddressParser.getInstance().parse(null);
        assertEquals(Collections.emptyList(), array);
    }

    @Test
    public void testMailAddressParser() {
        String address = "test.test@gmail.com";
        List<String> array = MailAddressParser.getInstance().parse(address);
        assertEquals(address, array.get(0));
    }
}
