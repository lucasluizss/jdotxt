# Report - Assignment #05

> **Anastasiia Dunaeva** - up202202453
>
> **Lucas Silva** - up202103397
>
> **Francisco Pacheco** - up201906505

## Line and branch coverage of the unit tests

> tests developed in Assignment #2 and Assignment #3.

![old coverage image](../.github/%2305/old_result.png)

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

  ```java
  // e.g.
  @Before
  public void setUp() throws IOException {
    test = new FileModifiedWatcher();
    watcher = FileSystems.getDefault().newWatchService();
    file = new File(path); // com/chschmid/jdotxt/util/DelayedActionHandler.java
    file1 = new File(path1);
    key = null;
  }
  ```

- `@BeforeClass`

  - Used to execute a statement before all the test cases. Normally it was used for creating objects that will keep the same instance through the tests in the same class.

  ```java
  // e.g.
    @BeforeClass
  public static void beforeClassFunction() {
  	DEFAULTDIR = Jdotxt.DEFAULT_DIR;
  	TODO_TXT_FILE = new File(DEFAULTDIR + File.separator + "todo.txt");
    }
  ```

- `@AfterClass`

  - Used to execute a statement after all the test cases. It was used for clening garbage not needed after tests execution. For deleting temp files for example.

  ```java
  // e.g.
    @AfterClass
  public static void afterClassFunction() throws IOException {
  	deleteDefaultFile();
  	deleteRenamedFile();
  }
  ```

- `@Test(expected = TodoException.class)`

  - As the first one mentioned above, this will describe a method as a test and it will expect an error during its execution. It will prevent the failure of the test by abstracting its result and validating the assertion.

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
  - In case we need to test some functionality with multiple options of parameters with the same type, we can use ParameterizedTest to avoid code duplication.
  - We used this decorator in order to specify that this testing method will be used with multiple values, making easy the process of testing the same functionality with different parameters/values.
- `@ValueSource`

  - ValueSource provides an array of values for the test. It's also possible to inform different types of values having the target method in consideration.

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

- `@Ignore`

  - Used to ignore some statements during test execution. It can be used for both classes and methods.
  - Sometimes when trying to raise more tests, we've struggled to write good and understandable tests that we decided to move on and conclude later. For keeping the test progressing without affecting the coverage result we used the ignore decorator that will not run the test.

  ```java
    // e.g.
    @Ignore
    @Test
    public void testUpdateTaskt() {
        Task task = new Task(1, "texto");
        task.update("updated");
        assertEquals("updated", task.getText());
    }
  ```

- `assertTrue`

  - Assert that expected parameter is true.

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

  - Assert that expected parameter is false

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

  - Assert that expected parameter is null

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

[!new coverage image](../.github/%2305/coverage.png)

A line/branch coverage is not close to 100% because of following reasons:

- Exceptions which are difficult to simulate

  - There are try-catch blocks in a code, where it is difficult to simulate exception for catch.
  - There is no easy way to find out which kind of parameters could be used for simulating possible failures.

  ![exception-sample image](../.github/%2305/exception-sample.png)

  ```java
    // e.g.
  public static void writeToFile(List<Task> tasks, File file, boolean append) {
  	try {
  		if (!Util.isDeviceWritable()) {
  			throw new IOException("Device is not writable!");
  		}
  		Util.createParentDirectory(file);
  		OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(file, append), encoding);

  		for (int i = 0; i < tasks.size(); ++i) {
  			String fileFormat = tasks.get(i).inFileFormat();
  			fw.write(fileFormat);
  			if (sWindowsLineBreaks) {
  				fw.write("\r\n");
  			} else {
  				fw.write("\n");
  			}
  		}
  		fw.close();
  	} catch (Exception e) {
  		System.out.printf(TAG, e.getMessage());
  	}
  }
  ```

- Private functions

  - Some functions are private, but they are still shown uncovered by the library.
  - Its usage depend on different calling functions that is not well listed in the testing class.

  ```java
  // e.g.
  private void initThread() {
  	t = new Thread(new DelayRunnable());
  	t.start();
  }
  ```

- Not 100% condition coverage in case of multiple conditions in one if/loop statement

  - If/loops statement with multiple conditions still shown as uncovered, if not all of conditions were covered.

  ```java
  // e.g.
  private void fireFileModified() {
    for (int i = fileModifiedListenerList.size()-1; i >= 0; i--) fileModifiedListenerList.get(i).fileModified();
  }
  ```

- Unreachable parts of code

  - I can be if/loop statement which is always false because function it depends on always returnes false.

  ```java
    // e.g.
    public static boolean isDeviceWritable() {
        return true;
    }

    public static void writeToFile(List<Task> tasks, File file, boolean append) {
        try {
  			if (!Util.isDeviceWritable()) {
  				throw new IOException("Device is not writable!");
  			}
            // some code
        }
        // some code
    }
  ```

  </br>

### com.todotxt.todotxttouch.task

- Some of the classes were harder to increase the coverage because of the reasons listed previously.
- In this package we can check how specific classes can impact the final coverage for this package.

- `e.g.`
  ![com.todotxt.todotxttouch.task image](../.github/%2305/com.todotxt.todotxttouch.task.png)

### com.todotxt.todotxttouch.util

- `e.g.`
  ![com.todotxt.todotxttouch.util image](../.github/%2305/com.todotxt.todotxttouch.util.png)

### com.todotxt.todotxttouch.task.sorter

- `e.g.`
  ![com.todotxt.todotxttouch.task.sorter image](../.github/%2305/com.todotxt.todotxttouch.task.sorter.png)

### com.chschmid.jdotxt.util

- Most of the parts that remain to be covered depend on a single unreachable condition

  ![com.chschmid.jdotxt.util image](../.github/%2305/com.chschmid.jdotxt.util.png)

- In the following images we can see that it is impossible to get to that specific part of the code, so it is impossible to cover it in the tests, because it just advance if the property is false but just reach the code to be coverd if the property is true, and it's the only call to that private class.

  ![com.chschmid.jdotxt.util condition](../.github/%2305/condition.png)

  ![com.chschmid.jdotxt.util impossibleCoverage](../.github/%2305/impossibleCoverage.png)
