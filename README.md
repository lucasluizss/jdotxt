# jdotxt

[![CircleCI](https://circleci.com/gh/nicdnb/jdotxt/tree/master.svg?style=svg)](https://circleci.com/gh/nicdnb/jdotxt/tree/master)

![screenshot](.github/jdotxt_program.png)

Copyright 2013-2018 Christian M. Schmid

another open source cross-platform GUI for the todo.txt file format

#### Website

- [jdotxt](http://jdotxt.chschmid.com/), where you will find downloads for different operating systems and a quick guide video

#### Building jdotxt

to build jdotxt from its sources, you will need

- a Java Development Kit (JDK) Version 7 or higher http://www.oracle.com/technetwork/java/javase/downloads/index.html
- Apache Maven as build system https://maven.apache.org/

I use Ubuntu as a build system, simply run

- sudo apt-get install openjdk-7-jdk maven

to set up your build system.

To build jdotxt

1. Download the latest sources from github (e.g., "git clone https://github.com/chms/jdotxt.git")

2. Move into the directory (e.g., "cd jdotxt")

3. Run maven (i.e., "mvn package")

You can run the resulting jar file by executing

java -jar target/jdotxt-0.4.9-SNAPSHOT-jar-with-dependencies.jar

#### Third Party Code

jdotxt uses code and libraries from the following open source projects:

- [appbundle-maven-plugin](https://github.com/federkasten/appbundle-maven-plugin): for creating the OSX app bundle.
- [todo.txt-android](https://github.com/ginatrapani/todo.txt-android): jdotxt uses the same datastructures and IO functions that the official Android client uses.
- [hamcrest](http://hamcrest.org/): for testing.
- [Java Native Access (JNA)](https://github.com/twall/jna#readme): for fixing some Windows 7/8 taskbar issues.
- [junit](http://junit.org/): for testing.
- [juniversalchardet](http://code.google.com/p/juniversalchardet/): for automatically detecting the encoding scheme of your todo files.

#### Misc Links

- [jdotxt](http://jdotxt.chschmid.com/), binaries and help for this very program.
- [todo.txt](http://todotxt.com/) is a simple file format for managing your todos.
- [todo.txt-android](https://github.com/ginatrapani/todo.txt-android) an open source todo.txt Android client
