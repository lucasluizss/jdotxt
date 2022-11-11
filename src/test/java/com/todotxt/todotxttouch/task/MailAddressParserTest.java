package com.todotxt.todotxttouch.task;

import org.junit.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MailAddressParserTest {

    String expected = null;

    String actual = null;

    @Test
    public void parseOneTest(){
        String input = "teste@teste.pt";
        expected = "[teste@teste.pt]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void parseMultipleTest(){
        String input = "fvp@teste.com, teste@teste.pt";
        expected = "[fvp@teste.com, teste@teste.pt]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void parseRightWrongTest(){
        String input = "fvp@teste.com, teste/teste.pt";
        expected = "[fvp@teste.com]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"teste/teste.pt", "teste", "@teste.pt", "@.pt", "@pt", "@teste", ""})
    public void parseWrongTest(String input){
        expected = "[]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }

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
