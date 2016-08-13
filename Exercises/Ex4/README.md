
## Overview

This assignment will test your ability to test. The provided code is for a half-baked
Dropbox implementation. The original developers quit for higher paying jobs at Facebook
and have left you with this code base. Your goal is to create a comprehensive set of tests for the
code base and a report detailing what works and what doesn't. If you don't do a thorough
job, your boss will assume that later bugs are your fault and put you on a performance
improvement plan (a precursor to being "let go to explore other career options"). Your test infrastructure
should cover as much of the code base as possible and as many use cases as possible.
In your report, when detailing something that doesn't work, you must provide the fully
qualified class name of your JUnit test and the test method that demonstrates the flaw.

**Hint:** The developers of this code base didn't pay much attention to testability. You may
find that some parts of the code are very difficult to test and tightly-coupled to
other classes or specific libraries. You CAN AND SHOULD refactor the code where 
appropriate to make it easier to test (but not less functional!).

**Hint:** Some of this code may be difficult to test without using mock objects.

## Instructions

The half-baked Dropbox app is launched by starting a first computer to act as the
primary server and then one or more clients that connect to the server. You provide
a directory that you want the server and each client to watch and they automatically
synchronize the files in their watched directories. 

### Fix the Broken Build

Before leaving, the old developers checked in a version of the application that didn't
build correctly. It appears that they added some dependencies to the build.gradle file
but forgot to check-in the updated version. Your first task is to figure out what dependencies
are missing from the build.gradle file and add them so that the application compiles.

### Start the Dropbox Server

1. Run (top menu bar)-> Run Configurations -> Select Java Applications ->
   Click New -> Set the project to JavaTestingExercise and the main class to
   the Dropbox class

2. Under arguments, provide the fully qualified path to a test directory that
   the application will synchronize for changes. 
   
   e.g.:
   
   `/foo/bar/some_safe_testing_dir`
   
   **WARNING:** This application is buggy and should not be given a directory with 
   any form of important work that could be lost. You should create a new directory
   specifically for testing this application. Do not set the path to the root of
   your file system.
   
3. Click Run

### Start a Dropbox Client

1. Follow Step 1 above, but change the name of the new run configuration

2. Under arguments, provide the path to a new test directory and then the IP address
   where you are running the server. If you want to run the server on the same
   computer, use ifconfig (Mac) or ipconfig (Windows) to get your IP address.
   
   Note: strange things may happen if the client / server run on the same machine
   and use the same directory...
   
   e.g.:
   
   `/foo/bar/some_other_safe_testing_dir 10.0.0.10`
   
3. Click Run


## Testing

You will need to create JUnit tests for this project. You can easily create these
tests by right-clicking on a package -> New -> JUnit Test Case. Each method annotated
with `@Test` will be run as a test. 

In order run a test case right-click on the JUnit test case
and select "run as"->"JUnit Test" if you are asked to "select the preferred launcher," 
check "use configuration specific settings" and then select the "Eclipse JUnit Launcher."

To complete this assignment correctly, you will need multiple JUnit tests, each with one
or more methods to test different aspects of the code base. You are free to organize your
tests into packages however you would like. You are also free to create a separate testing
project if you would prefer to separate your tests from the main code base.
