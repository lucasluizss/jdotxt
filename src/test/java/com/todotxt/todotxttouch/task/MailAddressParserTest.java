package com.todotxt.todotxttouch.task;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    /*
    @Test
    public void parseEmptyTest(){
        String input = "";
        expected = "[]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }
    */

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

}
