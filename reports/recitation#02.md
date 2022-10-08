# Report - Recitation #02

Commits available at [forked repository](https://github.com/lucasluizss/jdotxt).

> **Lucas Silva** - up202103397

## Selected functions and reasons

- `com.todotxt.todotxttouch.util.CursorPositionCalculator.calculate​`
  - This function were selected because there was not tests for it and it contained a logic for getting the cursor position.
- `com.todotxt.todotxttouch.util.Path.fileName`
  - This function were chosen because it handles the file name and process it's name returning it.
- `com.todotxt.todotxttouch.util.Path.parentPath`
  - This function were chosen because it handles the parent path and return it's path.
- `com.todotxt.todotxttouch.util.Util.createParentDirectory`
  - This function were chosen because it is responsible for creating parent directory that is used in the program.
- `com.todotxt.todotxttouch.util.Util.renameFile`
  - This function were chosen for being responsible for renaming the files used in the program.

## What is the purpose of each function.

- `com.todotxt.todotxttouch.util.CursorPositionCalculator.calculate​`
  - This function calculates the cursor position when a string changes based on the cursor position prior to the change.
- `com.todotxt.todotxttouch.util.Path.fileName`
  - It will verify if file name is blank and validate it's content by returning the validated file name or an empty string if not valid.
- `com.todotxt.todotxttouch.util.Path.parentPath`
  - It will verify if parent path is blank and validate it's content by returning the validated parent path or an empty string if not valid.
- `com.todotxt.todotxttouch.util.Util.createParentDirectory`
  - Create new parent directory folder of a file for the program usage.
- `com.todotxt.todotxttouch.util.Util.renameFile`
  - This function is used for renaming files in the program.

## Step-by-step of the ‘Category-Partition’ algorithm for each function.

- `com.todotxt.todotxttouch.util.CursorPositionCalculator.calculate​`
  - First identifying the class type and how the functions could be called.
  - Analysing the parameters types.
  - Depending on the value of parameters (_invalid/null_) the returned value can be zero.
- `com.todotxt.todotxttouch.util.Path.fileName`
  - First identifying the class type and how the functions could be called.
  - Analysing the parameter type.
  - Testing with different inputs.
  - Getting the correct result.
- `com.todotxt.todotxttouch.util.Path.parentPath`
  - First identifying the class type and how the functions could be called.
  - Analysing the parameter type.
  - Testing with different inputs.
  - Getting the correct result.
- `com.todotxt.todotxttouch.util.Util.createParentDirectory`
  - Identifying the usage of the function.
  - Analysing it parameter types for creating a parent directory.
  - Testing with different inputs and handling possible exceptions in tests.
  - Verifying created directories and deleting it at the end if necessary.
- `com.todotxt.todotxttouch.util.Util.renameFile`
  - Checking how the function was used.
  - Analysing the paramters for renaming a file.
  - Creating file in order to rename it.
  - Verifying the renamed file and possible errors.

## Brief description of the unit tests generated for each category.

- `com.todotxt.todotxttouch.util.CursorPositionCalculator.calculate​`
  - The tests were generated based on the parameters, for testing each possibility and checking the returned position if it matches.
  - Testing with a prior value, new value and position.
- `com.todotxt.todotxttouch.util.Path.fileName`
  - Each unit test were created for cover each possible condition like a file name starting or ending with slash "`/`", an empty string or null for returning it correct file name.
- `com.todotxt.todotxttouch.util.Path.parentPath`
  - Each unit test were created for cover each possible condition like a file name starting or ending with slash "`/`", an empty string or null for returning it correct parent path.
- `com.todotxt.todotxttouch.util.Util.createParentDirectory`
  - The unit tests were created in order of prevent possible defects, handling the parent directory creation used by the program.
- `com.todotxt.todotxttouch.util.Util.renameFile`
  - The unit tests were created for validating the file renaming and possible defects.

## Brief description of the outcome of each unit test and whether any test results in a failure (and why).

- `com.todotxt.todotxttouch.util.CursorPositionCalculator.calculate​`
  - Not possible to force an error execution, because this function has validations for every passed parameter.
- `com.todotxt.todotxttouch.util.Path.fileName`
  - It is not possible to create a failure test because the function prevent the failure because the string parameter type.
- `com.todotxt.todotxttouch.util.Path.parentPath`
  - It is not possible to create a failure test because the function prevent the failure because the string parameter type.
- `com.todotxt.todotxttouch.util.Util.createParentDirectory`
  - The unit tests can validate the exception cases when informing invalid inputs, or validating the correct creation of the parent directories.
- `com.todotxt.todotxttouch.util.Util.renameFile`
  - The unit tests can validate file renaming and possible exceptions when trying to rename a nonexistent file.
