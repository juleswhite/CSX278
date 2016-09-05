# Exercise 3

## Overview

In order to be an effective software developer, you need to understand the key tools
of the trade for your particular programming language. For this course, all of the
assignments will be in Java. This exercise will introduce you to the key tools that
we will be using: Eclipse, Gradle, Git, the Eclipse Debugger, and JUnit. You should
already be familiar with Eclipse basics from past courses.

## Step 0 - Setup Your Assignment

Since the last class, you should have setup a development environment with Eclipse,
Gradle, and Git.
Clone this repository and import this project into Eclipse. If you aren't a Git
expert yet, don't worry, the next class will give you hands-on experience with 
Git.

__Do This:__ When you are done, find the org.magnum.cs278.bootstrapex. Student 
class in the src/main/java folder and update all three variables exactly as described 
in the comments. 

## Step 1 - Running JUnit Tests

A critical part of software engineering is performing automated testing of code. JUnit
is a library that is commonly used to automate testing in Java. We will be using JUnit
throughout the course. Today, we aren't going to dive into the details of JUnit yet, but you do need to know
how to run JUnit tests in Eclipse. JUnit tests in a Gradle project are always going to
be stored under the /src/test/java folder. 

__Do This:__ Find the BootstrapTest class under src/test/java, right-click->Run As->JUnit test. 
Eclipse should run the test and display the results in the JUnit view. As you can 
see, there were some test failures.

## Step 2 - Understanding Gradle

A build process is an automated assembly line for taking your source code and
other artifacts and compiling, testing, and packaging them for distribution. A
build process automates all of the manual steps of taking your code from its
raw source format to the format that can be easily distributed to end customers
and run. A build process can encompass a variety of steps ranging from compilation
to documentation generation to actual copying of binaries to servers for deployment.

Gradle is a tool for automating Java build processes. By default, Gradle automatically
compiles, tests, and packages your code if your project structure matches its 
expectations. This class will introduce you to the basics of Gradle projects, 
what Gradle does for you, and how you use Gradle to increase your productivity.


__Gradle Project Structure__ - Gradle expects all of your code to be in a folder
with sub folders following the following format:
  - __project_dir/__
    
    Every project should have a root directory that it lives beneath. 
  
  - __project_dir/build.gradle__
  
    Every project should have a build.gradle file in the root project directory.
  
  - __project_dir/src/main/java__
  
    The source code for your application lives beneath the src/main/java folder in
    appropriately named folders reflecting the Java packages of the classes. If your
    class "Foo" is in the package "org.cs278", then it would live in the file:
    
    project_dir/src/main/java/org/cs278/Foo.java
  
  - __project_dir/src/test/java__
  
    This folder contains the tests, such as JUnit tests, for your source code. 
    
__The build.gradle File__ - Every time that Gradle is run, it looks for the build.gradle
file in the root of your project. This file defines the build steps that are taken,
what dependencies (e.g., JAR files) are needed to compile your code, and any other
packaging steps that need to be taken. Gradle files are written in the Groovy scripting
language. 99% of the time, you do not need to do much in a build.gradle file other than
add the appropriate library dependencies that your application needs to be compiled.

A simple build.gradle file is shown below:

```java
apply plugin: 'java'
apply plugin: 'eclipse'

sourceCompatibility = 1.8
targetCompatibility = 1.8

repositories {
    mavenCentral()
}

dependencies {
    compile("com.google.guava:guava:17.0")
    compile("org.apache.commons:commons-lang3:3.3.2")
}

task wrapper(type: Wrapper) {
    gradleVersion = '1.11'
}
```

The key section that you will edit in most project is the dependencies. This example
is dependent on two libraries, "Guava" a great collection of utilities provided by
Google, and "Commons Lang" another set of helpful utilities provide by Apache. When
you run a build, Gradle goes and downloads these dependencies from a repository
(e.g., mavenCentral() ), installs them into your project, and adds them to the classpath
used by the compiler, Eclipse, and your tests. 

You can search for dependencies that you need in the Maven Central repository here:
http://mvnrepository.com/search.html?query=guava

__Do This:__ Now, for the first step, use Maven Central to find the latest version of the "CGlib"
or "Code Generation Library" library and add it to your build.gradle file as a dependency. 

Each time that you make a change to your build.gradle file in Eclipse, you need to
"refresh" it so that Eclipse will be updated with the changes. To update your build.gradle
file, right-click on the project root folder->Gradle->Refresh Gradle Project. Gradle 
will run, download any new dependencies, and then reconfigure your Eclipse project. 
Go ahead and refresh your build.gradle file to pickup the changes that you made.

You now have completed a crash course in the basics of Gradle. You can find and add
libraries to an existing Gradle file when you need to. You will be using Gradle throughout
the course -- make sure that you ask __in class__ about anything that you are confused
by.
    
__How to Start a New Project__ - Most new projects will have similar build requirements
to a past project. To start a new project, you should *ideally* identify an existing
project that already performs the build steps that you want, copy its project root
directory, remove all of the source code under /src/main/java, /src/test/java, etc., 
and then remove any unneeded dependencies from the build.gradle file. You can then
import this project into Eclipse to get started on a new project and begin adding your
code to /src/main/java, etc.

## Step 3 - Using the Eclipse Console and Reading Stack Traces

To run the application that you imported, right-click on the App class beneath /src/main/java
and Run As->Java Application. If the Eclipse Console view is not already open, open it via
Window->Show View->Console. You should see an error, called a Java stack trace, printed in the
console. 

A stack trace displays the chain of method invocations that produced an exception. Knowing how
to read stack traces is very important and usually simple. Below is an example stack trace:

```
Exception in thread "main" java.lang.IllegalStateException: A book has a null property
        at com.example.myproject.Author.getBookIds(Author.java:38)
        at com.example.myproject.Bootstrap.main(Bootstrap.java:14)
Caused by: java.lang.NullPointerException
        at com.example.myproject.Book.getId(Book.java:22)
        at com.example.myproject.Author.getBookIds(Author.java:35)
        ... 1 more
```

A stack trace will either have a direct cause or a series of causes. If an exception A1
causes an exception A2 to be thrown, Java will print out A2 as being "caused by" A1. When
you are reading stack traces, you usually want to start by finding the root cause, which will
be the "caused by" that is farthest down in the list. In the example above, a NullPointerException
caused another part of the code to throw an IllegalStateException. The real exception that the
developer needs to debug is the NullPointerException. If there is only a single exception thrown,
only that exception will be listed and no "caused by" will be printed.

The stack trace displays the exact methods and line numbers that were executing when the exception
was thrown. In the example above, line 22 in Book.java was the place where the NullPointerException
was thrown. You should always refer to these line numbers to find the exact location where an error
occurred.

__Do This:__ After running the App class again, look at the Eclipse Console and find the stack trace that
was printed. Write down the full class name (e.g., include the package name) of the class that
generated the exception and the line number where the exception was thrown. Then, open the
BootstrapTest.testStep3() method in the src/test/java folder and update the thrower and line
number variables. You will need to provide the class object, not the string name, of the 
thrower. If you noticed that "com.foo.Foo" generated the exception, then you would refer to
this class' class object as follows:

```
thrower = com.foo.Foo.class;
```

When you are done, run the BootstrapTest JUnit test again to check if you correctly found
the source of the exception. Also, running the JUnit test will update your progress on the
assignment.

## Step 4 - Using the Eclipse Debugger

Inevitably, you will write code with bugs. Great programmers are intimately familiar with
how to use the debugger for their particular language of choice. Eclipse has a
fantastic debugger that you will learn the basics of in this step. 

The most fundamental concept in debugging is the idea of a breakpoint. A breakpoint is
a location in the code where you would like to have the program's execution pause so that
you can inspect the variable values, see where the call came from, or walk step by step
through the remaining lines. When you open a Java source file in Eclipse, there is a small 
gray or blue bar on the  left-hand side of the editor. You can double click in this area 
next to any line of code in a Java file to set a breakpoint. Once you have set a breakpoint,
you can run your application and have it pause there by right-clicking on your main class->
Debug As->Java Application. The program will execute until it hits your breakpoint and then
pause and ask you if you want to switch to the debugging view. 

Go ahead and open the BootstrapTest again and add a breakpoint next to this line of code
in testStep3():

```java
App.main(null);
```

Now, right-click on the BootstrapTest->Debug As->JUnit Test to run the code in the debugger
and see it stop at your breakpoint. When your breakpoint is hit, Eclipse will ask you if
you want to switch to the debugging perspective. Select yes and Eclipse should open up
a new set of views. In the upper left corner, you should see the stack of method calls
that leading up to the method where the breakpoint was set. You can click on any of the
methods in the stack to navigate to them. In the upper right hand corner, you can see the
list of variables that are currently in scope and their values. If a variable is a class with
member variables, you can expand it to see the member variable values. 

After a breakpoint is hit, you can use the play, stop, and other controls on the top toolbar
to control the execution of the application. The play button will continue running the application
until the next breakpoint is hit. The stop button will terminate the application. The "step into"
button allows you to advance the execution of the debugger into a method call. Go ahead and hit the
"step into" button and you should see the program execution continue into the main() method and
open up the corresponding line of code. Now, use the "step over" button to advance the execution
of the application without diving into the next method invocation to the wrap() method. 

__Do This:__ At this point, you should know the basics of using the debugger to stop the execution of your
program, inspect variable values, and step through the code. To complete the assignment, use
your knowledge of reading stack traces and using the debugger to find the bug in the current
application. Once you have found the bug, which is a simple typo, fix the bug and run the 
BootstrapTest to ensure that you have fixed it correctly. The Bootstrap test will also update
your progress and hand-in your assignment so that you get credit. To get started, you might
want to put a breakpoint at or immediately before the line that is throwing the exception when
you run the App class.

__Good luck!__
   
