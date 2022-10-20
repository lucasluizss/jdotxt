# Report - Assignment #03

Commits available at [forked repository](https://github.com/lucasluizss/jdotxt).

> **Lucas Silva** - up202103397
> **Anastasiia Dunaeva** - up202202453

## Which functions have you selected for testing and why.

- `com.todotxt.todotxttouch.util.Strings.insertPadded​`
  - This function were chosen because it will insert spaces in the requested position regarding the parameters.
- `com.todotxt.todotxttouch.util.Strings.isEmptyOrNull​`
  - This function were chosen because it will verify if the passed string is not valid.
- `com.todotxt.todotxttouch.util.RelativeDate.getRelativeDate​`
  - This function was chosed because its values create seven different partitions and six explicit boundaries between them.

## What is the purpose of each function.

- `com.todotxt.todotxttouch.util.Strings.insertPadded​`
  - Inserts a given string into another padding it with spaces.
- `com.todotxt.todotxttouch.util.Strings.isEmptyOrNull​`
  - Checks the passed in string to see if it is null or an empty string.
- `com.todotxt.todotxttouch.util.RelativeDate.getRelativeDate​`
  - Returns a difference between dates as a string

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

### `com.todotxt.todotxttouch.util.RelativeDate.getRelativeDate​`

- Signature:
  ```java
    public static String getRelativeDate(Calendar d1, Calendar d2)
  ```
- Description:
  - Returns a string which represents how much later the first date is than the second. 
- Parameters & Boundaries:
  - `d1` - the first _calendar_
  - `d2` - the second _calendar_
- Partitions:
    - E1: `d2` is later than `d1`
    - E2: `d1` is later than `d2` by less than a day
    - E3: `d1` is later than `d2` by less than 2 days, more than a day
    - E4: `d1` is later than `d2` by less than 30 days, more than 2 days
    - E5: `d1` is later than `d2` by less than 60 days, more than 30 days
    - E6: `d1` is later than `d2` by less than a year, more than 60 days
    - E7: `d1` is later than `d2` by more than a year
- Boundaries:
  - `d1` = `d2` (E2)
  - `d1` a day later than `d2` (E3)
  - `d1` 2 days later than `d2` (E4)
  - `d1` 30 days later than `d2` (E5)
  - `d1` 60 days later than `d2` (E6)
  - `d1` a year later than `d2` (E7)
- **Returns**: one of the following string: "today", "1 day ago", "2 days ago", "N days ago", "1 month ago", "2 months ago", "N months ago", `d2` in format yyyy-mm-dd
  ![relative_date_image](../.github/%2303/relativeDate.png)

## Brief description of the unit tests generated for each ‘boundary’.

| Function        | Boundary | Unit Testing               | Description                                                                                                                 |
|-----------------|----------|----------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| insertPadded    | E1       | insertPaddedE1             | Passing empty string in parameter `s` that return an empty string as expected.                                              |
|                 | E2       | insertPaddedE2             | Passing null string in parameter `s` that return a **_NullPointerException_** as expected.                                  |
|                 | E3       | insertPaddedE3             | Passing string with spaces in parameter `s` that return a new string with the expected character.                           |
|                 | E4       | insertPaddedE4             | Passing valid string in parameter `s` that return a new string with the expected value.                                     |
|                 | E5       | insertPaddedE5             | Passing a negative value in parameter `insertAt` will throw an **_IndexOutOfBoundsException_** exception.                   |
|                 | E6       | insertPaddedE6             | Passing a value greater then string lenght in parameter `insertAt` will throw an **_IndexOutOfBoundsException_** exception. |
|                 | E7       | insertPaddedE7             | Passign a valid value in parameter `insertAt` will return the expected inserted string in the correct place.                |
|                 | E8       | insertPaddedE8             | Passing empty string in parameter `stringToInsert` that return the content of parameter `s`.                                |
|                 | E9       | insertPaddedE9             | Passing a null string in parameter `stringToInsert` that return the content of parameter `s`.                               |
|                 | E10      | insertPaddedE10            | Passing a blank string in parameter `stringToInsert` that return `s` with the inserted spaces in the specified position.    |
|                 | E11      | insertPaddedE11            | Passing a valdid string will return the new string as expected.                                                             |
| isEmptyOrNull​  | E1       | isEmptyOrNull​E1           | Passing empty string in parameter `s` that return true.                                                                     |
|                 | E2       | isEmptyOrNull​E2           | Passing null string in parameter `s` that return true.                                                                      |
|                 | E3       | isEmptyOrNull​E3           | Passing string with spaces in parameter `s` that return false.                                                              |
|                 | E4       | isEmptyOrNull​E4           | Passing valid string in parameter `s` that return false.                                                                    |
| getRelativeDate | E1       | getRelativeDate​E1         | Passing `d2` one day later than `d1`  .                                                                                     |
|                 | E2       | getRelativeDate​E2Boundary | Passing `d1` equals `d1`.                                                                                                   |
|                 | E2       | getRelativeDate​E2         | Passing `d1` 22 hours later than `d2`.                                                                                      |
|                 | E3       | getRelativeDate​E3Boundary | Passing `d1` 1 day later than `d2`.                                                                                         |
|                 | E3       | getRelativeDate​E3         | Passing `d1` 1 day and 22 hours later than `d2`.                                                                            |
|                 | E4       | getRelativeDate​E4Boundary | Passing `d1` 2 days later than `d2`.                                                                                        |
|                 | E4       | getRelativeDate​E4         | Passing `d1` 29 days later than `d2`.                                                                                       |
|                 | E5       | getRelativeDate​E5Boundary | Passing `d1` 30 days later than `d2`.                                                                                       |
|                 | E5       | getRelativeDate​E5         | Passing `d1` 59 days later than `d2`.                                                                                       |
|                 | E6       | getRelativeDate​E6Boundary | Passing `d1` 60 days later than `d2`.                                                                                       |
|                 | E6       | getRelativeDate​E6         | Passing `d1` 11 months later than `d2`.                                                                                     |
|                 | E7       | getRelativeDate​E7Boundary | Passing `d1` 1 year later than `d2`.                                                                                        |

## Brief description of the outcome of each unit test and whether any test results in a failure (and why).

| Function                   | Input(s)                              | Output(s)                          |
|----------------------------|---------------------------------------|------------------------------------|
| insertPaddedE1             | ("", 0, "test1")                      | "test1"                            |
| insertPaddedE2             | (null, 0, "test2)                     | throws `NullPointerException`      |
| insertPaddedE3             | (" ", 0, "test")                      | "test "                            |
| insertPaddedE4             | ("4", 0, "test")                      | "test 4"                           |
| insertPaddedE5             | ("5", -1, "test")                     | throws `IndexOutOfBoundsException` |
| insertPaddedE6             | ("6", 5, "test")                      | throws `IndexOutOfBoundsException` |
| insertPaddedE7             | ("my boundary", 3, "7th")             | "my 7th boundary"                  |
| insertPaddedE8             | ("my boundary", 3, "")                | "my boundary"                      |
| insertPaddedE9             | ("my boundary", 3, null)              | "my boundary"                      |
| insertPaddedE10            | ("my boundary", 2, " ")               | "my boundary"                      |
| insertPaddedE11            | ("my boundary", 2, "11th")            | "my 11th boundary"                 |
| isEmptyOrNull​E1           | ("")                                  | True                               |
| isEmptyOrNull​E2           | (null)                                | True                               |
| isEmptyOrNull​E3           | (" ")                                 | False                              |
| isEmptyOrNull​E4           | ("asd")                               | False                              |
| getRelativeDateE1​         | ("2015-01-04", "2015-01-05")          | "2015-01-05"                       |
| getRelativeDateE2Boundary​ | ("2015-01-05", "2015-01-05")          | "today"                            |
| getRelativeDateE2​         | ("2015-01-05 22:00:00", "2015-01-05") | "today"                            |
| getRelativeDateE3Boundary​ | ("2015-01-06", "2015-01-05")          | "1 day ago"                        |
| getRelativeDateE3​         | ("2015-01-06 22:00:00", "2015-01-05") | "1 day ago"                        |
| getRelativeDateE4Boundary​ | ("2015-01-07", "2015-01-05")          | "2 days ago"                       |
| getRelativeDateE4​         | ("2015-02-03", "2015-01-05")          | "29 days ago"                      |
| getRelativeDateE5Boundary​ | ("2015-02-04", "2015-01-05")          | "1 month ago"                      |
| getRelativeDateE5​         | ("2015-03-04", "2015-01-05")          | "1 month ago"                      |
| getRelativeDateE6Boundary​ | ("2015-03-05", "2015-01-05")          | "2 months ago"                     |
| getRelativeDateE6​         | ("2015-12-05", "2015-01-05")          | "11 months ago"                    | 
| getRelativeDateE7Boundary​ | ("2016-01-05", "2015-01-05")          | "2015-01-05"                       |