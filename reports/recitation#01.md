# Report - Recitation #01

> > **Lucas Silva** - up202103397
>
> > **Garcia Manuel** - up202204409

## Description of your project.

- **What is it?**
  - The project is an open source cross-platform GUI for the `todo.txt` file format.
- **How is the source-code organized?**

```
   |-rulesets
   |-src
   |---main
   |-----java
   |-------com
   |---------chschmid
   |-----------jdotxt
   |-------------gui
   |---------------controls
   |---------------utils
   |-------------util
   |---------todotxt
   |-----------todotxttouch
   |-------------task
   |---------------sorter
   |-------------util
   |-----resources
   |-------drawable
   |-------fonts
   |-------lang
   |---test
   |-----java
   |-------com
   |---------todotxt
   |-----------todotxttouch
   |-------------task
   |-target
   |---archive-tmp
   |---classes
   |-----com
   |-------chschmid
   |---------jdotxt
   |-----------gui
   |-------------controls
   |-------------utils
   |-----------util
   |-------todotxt
   |---------todotxttouch
   |-----------task
   |-------------sorter
   |-----------util
   |-----drawable
   |-----fonts
   |-----lang
   |---generated-sources
   |-----annotations
   |---generated-test-sources
   |-----test-annotations
   |---maven-archiver
   |---maven-status
   |-----maven-compiler-plugin
   |-------compile
   |---------default-cli
   |---------default-compile
   |-------testCompile
   |---------default-testCompile
   |---site
   |-----css
   |-----images
   |-------logos
   |---surefire-reports
   |---test-classes
   |-----com
   |-------todotxt
   |---------todotxttouch
   |-----------task

```

## What static testing is and why do you think it is import and relevant.

Static testing can help us to define good quality of code reading, by improving and defining standards and most of all for checking system faults. It can also identify possible bugs in code.\
(Verderame, att all , 2020, p.74) Static analysis techniques enable the evaluation of an app by examining the source code and the package content without executing it.

## Static testing tool used in this assignment

### Checkstyle

- **How was it configured for your project.**
  > It is a development tool that helps programmers write code that meets industry standards. It automates the java code verification process which for programmers would be a long and tedious task. The tool is highly configured and can be used to support many development patterns.
  > The checkstyle can check various aspects of the source code, it can identify problems in class design, method design, and also the ability to check layout and formatting problems.\
  > It was configured using the `pom.xml` file by adding the plugin reference and the reporting plugin tag reference using the Intellij IDE. Also by using the `ruleset` recommended by google.

### Spotbugs

- **How was it configured for your project.**
  > Your description must explain, e.g., why did you enabled or disabled any default configuration or bug pattern.

## Report produced by the static testing tool.

### Checkstyle

[Generated Report](../target/site/checkstyle.html)

_Before:_

| Files | Info | Warnings | Errors |
| ----- | ---- | -------- | ------ |
| 67    | 0    | 12564    | 0      |

_After:_

| Files | Info | Warnings | Errors |
| ----- | ---- | -------- | ------ |
| 67    | 0    | 11750    | 0      |

#### 5x2 randomly selected bugs.

- NeedBraces - `com/chschmid/jdotxt/gui/controls/JdotxtTaskList.java` LN108
- EmptyBlock - `com/chschmid/jdotxt/gui/controls/JdotxtTaskList.java` LN302
- FileTabCharacter - `com/chschmid/jdotxt/gui/controls/JdotxtTaskList.java` LN448
- RightCurly - `com/chschmid/jdotxt/gui/controls/JdotxtTaskList.java` LN480
- EmptyLineSeparator - `com/chschmid/jdotxt/gui/controls/JdotxtTaskList.java` LN501

#### How those 5x2 bugs were addressed/fixed.

- NeedBraces
  - Before 'if' construct must use '{}'s.
  - It was added braces to the 'if' clausures.
- EmptyBlock
  - Before there was an empty `else` block.
  - After it was removed.
- FileTabCharacter
  - Before the file was indented with tabs.
  - After it was applied the space indentation for fixing the warning.
- RightCurly
  - Before the warning says that '}' at column 104 should be alone on a line.
  - After the code was indented by improving the method organisation. Also fixed the `LeftCurly`.
- EmptyLineSeparator
  - Before each 'METHOD_DEF' should be separated from previous line.
  - After it was fixed for every warning in the file by applying the IDE tool.

### Spotbug

[Generated Report](../target/site/spotbugs.html)

_Before:_

| Classes | Bugs | Errors | Missing Classes |
| ------- | ---- | ------ | --------------- |
| 215     | 75   | 0      | 0               |

_After:_

| Classes | Bugs | Errors | Missing Classes |
| ------- | ---- | ------ | --------------- |
| 215     | 68   | 0      | 0               |

#### 5x2 randomly selected bugs.

- MALICIOUS_CODE - `com.chschmid.jdotxt.gui.JdotxtGUI` LN59
- PERFORMANCE - `com.chschmid.jdotxt.gui.controls.JdotxtContentField$AutocompletionList` LN217
- CORRECTNESS - `com.todotxt.todotxttouch.util.Util` LN275
- BAD_PRACTICE - `com.todotxt.todotxttouch.task.LocalFileTaskRepository` LN61
- STYLE - `com.chschmid.jdotxt.gui.JdotxtWelcomeDialog` LN66

#### How those 5x2 bugs were addressed/fixed.

- MALICIOUS_CODE

  - Before the bug was refering to com.chschmid.jdotxt.gui.JdotxtGUI.COLOR_GRAY_PANEL isn't final but should be
  - After que variables was fixed by making them final.

- PERFORMANCE
  - Before the bug was complaining that it should com.chschmid.jdotxt.gui.controls.JdotxtContentField$AutocompletionList be a _static_ inner class?
  - After the class was asssigned as static within the property mentioned.
- CORRECTNESS
  - Before the bug was complaning that possible null pointer dereference of dir in com.todotxt.todotxttouch.util.Util.createParentDirectory(File)
  - It was added a null verification for preventing the exception.
- BAD_PRACTICE
  - Before, Exceptional return value of java.io.File.createNewFile() ignored in com.todotxt.todotxttouch.task.LocalFileTaskRepository.init().
  - After the returned value was used for showing it values as a logger.
- STYLE
  - Before switch statement found in com.chschmid.jdotxt.gui.JdotxtWelcomeDialog.initGUI() where default case is missing
  - After was added a log with no valid purpose for requested translation operation.
