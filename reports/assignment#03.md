# Report - Assignment #03

Commits available at [forked repository](https://github.com/lucasluizss/jdotxt).

> **Lucas Silva** - up202103397

## Which functions have you selected for testing and why.

- `com.todotxt.todotxttouch.util.Strings.insertPadded​`
  - This function were chosen because it will insert spaces in the requested position regarding the parameters.
- `com.todotxt.todotxttouch.util.Strings.isBlank​`
  - This function were chosen because it will verify if the string is not valid in three possible ways.
- `com.todotxt.todotxttouch.util.Strings.isEmptyOrNull​`
  - This function were chosen because it will verify if the passed string is not valid.

## What is the purpose of each function.

- `com.todotxt.todotxttouch.util.Strings.insertPadded​`
  - Inserts a given string into another padding it with spaces.
- `com.todotxt.todotxttouch.util.Strings.isBlank​`
  - Checks the passed in string to see if it is null, empty, or blank; where 'blank' is defined as consisting entirely of whitespace.
- `com.todotxt.todotxttouch.util.Strings.isEmptyOrNull​`
  - Checks the passed in string to see if it is null or an empty string.

## Step-by-step of the ‘Boundary Value Analysis’ for each function.

### `com.todotxt.todotxttouch.util.Strings.insertPadded​`

- Signature:
  ```java
    public static String insertPadded​(String s, int insertAt, String stringToInsert)
  ```
- Description:
  - Inserts a given string into another padding it with spaces. Is aware if the insertion point has a space on either end and does not add extra spaces.
- Parameters & Boundaries:
  - `s` - the _string_ to insert into
    - E1: empyt/blank string represented by `""`
    - E2: `null`
    - E3: string with spaces like `" "`
    - E4: valid string, that could be any string rather those mentioned above
  - `insertAt` - the position to insert the string of the type _integer_
    - E5: negative value like `-1`
    - E6: value greater than the string lenght
    - E7: valid value that can be any interger between the string lenght
  - `stringToInsert` - the _string_ to insert
    - E8: empyt/blank string represented by `""`
    - E9: `null`
    - E10: string with spaces like `" "`
    - E11: valid string, that could be any string rather those mentioned above
  - **Returns**: the result of inserting the stringToInsert into the passed in string
  - **Throws**: `IndexOutOfBoundsException` - if the insertAt is negative, or insertAt is larger than the length of s String object

### `com.todotxt.todotxttouch.util.Strings.isEmptyOrNull​`

- Signature:
  ```java
    public static boolean isEmptyOrNull​(String s)
  ```
- Description:
  - Checks the passed in string to see if it is null or an empty string
- Parameters & Boundaries:
  - `s` - the string to check
    - E1: empyt/blank string represented by `""`
    - E2: `null`
    - E3: string with spaces like `" "`
    - E4: valid string, that could be any string rather those mentioned above
  - **Returns**: `true` if `null` or `""`

### `com.todotxt.todotxttouch.util.Strings.isBlank​`

- Signature:
  ```java
    public static boolean isBlank(String s)
  ```
- Description:
  - Checks the passed in string to see if it is null, empty, or blank; where 'blank' is defined as consisting entirely of whitespace.
- Parameters & Boundaries:
  - `s` - the string to check
    - E1: empyt/blank string represented by `""`
    - E2: `null`
    - E3: string with spaces like `" "`
    - E4: valid string, that could be any string rather those mentioned above
  - **Returns**: `true` if `null` or `""` or all whitespace

## Brief description of the unit tests generated for each ‘boundary’.

| Function       | Boundary | Unit Testing     | Description                                                                                                                 |
| -------------- | -------- | ---------------- | --------------------------------------------------------------------------------------------------------------------------- |
| insertPadded   | E1       | insertPaddedE1   | Passing empty string in parameter `s` that return an empty string as expected.                                              |
|                | E2       | insertPaddedE2   | Passing null string in parameter `s` that return a **_NullPointerException_** as expected.                                  |
|                | E3       | insertPaddedE3   | Passing string with spaces in parameter `s` that return a new string with the expected character.                           |
|                | E4       | insertPaddedE4   | Passing valid string in parameter `s` that return a new string with the expected value.                                     |
|                | E5       | insertPaddedE5   | Passing a negative value in parameter `insertAt` will throw an **_IndexOutOfBoundsException_** exception.                   |
|                | E6       | insertPaddedE6   | Passing a value greater then string lenght in parameter `insertAt` will throw an **_IndexOutOfBoundsException_** exception. |
|                | E7       | insertPaddedE7   | Passign a valid value in parameter `insertAt` will return the expected inserted string in the correct place.                |
|                | E8       | insertPaddedE8   | Passing empty string in parameter `stringToInsert` that return the content of parameter `s`.                                |
|                | E9       | insertPaddedE9   | Passing a null string in parameter `stringToInsert` that return the content of parameter `s`.                               |
|                | E10      | insertPaddedE10  | Passing a blank string in parameter `stringToInsert` that return `s` with the inserted spaces in the specified position.    |
|                | E11      | insertPaddedE11  | Passing a valdid string will return the new string as expected.                                                             |
| isEmptyOrNull​ | E1       | isEmptyOrNull​E1 | Passing empty string in parameter `s` that return true.                                                                     |
|                | E2       | isEmptyOrNull​E2 | Passing null string in parameter `s` that return true.                                                                      |
|                | E3       | isEmptyOrNull​E3 | Passing string with spaces in parameter `s` that return false.                                                              |
|                | E4       | isEmptyOrNull​E4 | Passing valid string in parameter `s` that return false.                                                                    |
| isBlank        | E1       | isBlank​E1       | Passing empty string in parameter `s` that return true.                                                                     |
|                | E2       | isBlank​E2       | Passing null string in parameter `s` that return true.                                                                      |
|                | E3       | isBlank​E3       | Passing string with spaces in parameter `s` that return true.                                                               |
|                | E4       | isBlank​E4       | Passing valid string in parameter `s` that return false.                                                                    |

## Brief description of the outcome of each unit test and whether any test results in a failure (and why).

| Function         | Input(s)                   | Output(s)                          |
| ---------------- | -------------------------- | ---------------------------------- |
| insertPaddedE1   | ("", 0, "test1")           | "test1"                            |
| insertPaddedE2   | (null, 0, "test2)          | throws `NullPointerException`      |
| insertPaddedE3   | (" ", 0, "test")           | "test "                            |
| insertPaddedE4   | ("4", 0, "test")           | "test 4"                           |
| insertPaddedE5   | ("5", -1, "test")          | throws `IndexOutOfBoundsException` |
| insertPaddedE6   | ("6", 5, "test")           | throws `IndexOutOfBoundsException` |
| insertPaddedE7   | ("my boundary", 3, "7th")  | "my 7th boundary"                  |
| insertPaddedE8   | ("my boundary", 3, "")     | "my boundary"                      |
| insertPaddedE9   | ("my boundary", 3, null)   | "my boundary"                      |
| insertPaddedE10  | ("my boundary", 2, " ")    | "my boundary"                      |
| insertPaddedE11  | ("my boundary", 2, "11th") | "my 11th boundary"                 |
| isEmptyOrNull​E1 | ("")                       | True                               |
| isEmptyOrNull​E2 | (null)                     | True                               |
| isEmptyOrNull​E3 | (" ")                      | False                              |
| isEmptyOrNull​E4 | ("asd")                    | False                              |
| isBlank​E1       | ("")                       | True                               |
| isBlank​E2       | (null)                     | True                               |
| isBlank​E3       | (" ")                      | True                               |
| isBlank​E4       | ("asd")                    | False                              |
