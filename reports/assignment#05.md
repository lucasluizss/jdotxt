# Report - Assignment #05

> **Anastasiia Dunaeva** - up202202453
>
> **Lucas Silva** - up202103397
>
> **Francisco Pacheco** - up201906505

## Line and branch coverage of the unit tests

> tests developed in Assignment #2 and Assignment #3.

description/screenshots

## Brief description of the JUnit features explored by your tests

> e.g., parameterized tests (with the @ParameterizedTest annotation), assert expected exceptions (with the @Test(expected = ...) annotation), type of asserts (assertTrue, assertNull, …), etc.

- `@Test`
  - Tells JUnit which public void method can be run as a test case. Decorator for identify test methods.
  ```java
  // e.g.
  @Test
  void addition() {
  		assertEquals(2, calculator.add(1, 1));
  }
  ```
- `@Before`
  - To execute some statement before each test case. It was used for creating new instances and reuse objects/variables in following tests.
- `@BeforeClass`
  - Used to execute a statement before all the test cases. Normally it was used for creating objects that will keep the same instance through the tests in the same class.
- `@AfterClass`
  - Used to execute a statement after all the test cases. It was used for clening garbage not needed after tests execution. For deleting temp files for example.
- `@Test(expected = TodoException.class)`

  - As the first one mentioned above, this will describe a method as a test and it will expect an error during its execution.

  ```java
  // e.g.
  @Test(expected = TodoException.class)
  public void testThrowsTodoExceptionWhenPassingNullDestitaion() throws IOException, TodoException {
  	// arange
  	File dest = null;

  	// act & assert
  	Util.createParentDirectory(dest);
  }
  ```

- `assertEquals`
  - Asserts that two objects or values are equal. That's the most common method for asserting _expected_ results with _actual_.
-

## Line and branch coverage of the unit tests you have developed in this assignment.

screenshots
