package com.todotxt.todotxttouch.task;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class PhoneNumberParserTest {

	@Test
	public void PhoneNumberParserTest1() {
		String inputText = "912345679";
		PhoneNumberParser parser = PhoneNumberParser.getInstance();
		List<String> actual = parser.parse(inputText);
		List<String> expected = Arrays.asList();

		assertEquals(expected, actual);
	}
}