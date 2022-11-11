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
  
- `@ParameterizedTest`
- `@ValueSource`
  - In case we need to test some functionality with multiple options of parameters with the same type, we can use ParameterizedTest to avoid code duplication. ValueSource provides an array of values for the test.

  ```java
    // e.g.
    @ParameterizedTest
    @ValueSource(strings = {"teste/teste.pt", "teste", "@teste.pt", "@.pt", "@pt", "@teste", ""})
    public void parseWrongTest(String input){
        expected = "[]";
        actual = MailAddressParser.getInstance().parse(input).toString();
        assertEquals(expected, actual);
    }
  ```

- `@NullSource`
  - Provides a null parameter to the test

  ```java
    // e.g.
    @ParameterizedTest
    @NullSource
    public void testSplitNull(String text) {
        TextSplitter splitter = TextSplitter.getInstance();
        TextSplitter.SplitResult result = splitter.split(text);

        assertEquals(Priority.NONE, result.priority);
        assertEquals("", result.prependedDate);
        assertEquals("", result.text);
        assertFalse(result.completed);
        assertEquals("", result.completedDate);
    }
  ```
- `assertEquals`
  - Asserts that two objects or values are equal. That's the most common method for asserting _expected_ results with _actual_.

  ```java
    // e.g.
    @Test
    public void testUpdateTaskt() {
        Task task = new Task(1, "texto");
        task.update("updated");
        assertEquals("updated", task.getText());
    }
  ```
  
- `assertTrue`
  - Assert that parameter is true.

  ```java
    // e.g.
    @Test
    public void hiddenTest() {
        String task = "Hidden task h:1";
        boolean hidden = HiddenParser.getInstance().parse(task);
        assertTrue(hidden);
    }
  ```
- `assertFalse`
  - Assert that parameter is false

  ```java
    // e.g.
    @Test
    public void notHiddenTest() {
        String task = "Not hidden task";
        boolean hidden = HiddenParser.getInstance().parse(task);
        assertFalse(hidden);
    }
  ```
- `assertNull`
  - Assert that parameter is null

  ```java
    // e.g.
    @Test
	public void testReadStreamNull() {
		String returned = Util.readStream(null);

		assertNull(returned);
	}
  ```
- `assertNotNull`
  - Assert that parameter is not null

  ```java
    // e.g.
    @Test
    public void testConstructor1() {
        Task task = new Task();
        Task task1 = new Task(task);
        assertNotNull(task1);
    }
  ```

## Line and branch coverage of the unit tests you have developed in this assignment.

screenshots
