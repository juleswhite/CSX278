# In-class Assignment

## Overview

A challenging component of team software development is that individual
developers inevitably make changes to code that conflict with the changes
made by other developers. On any non-trivial project, there will be conflicts
between developers' changes. This exercise is going to teach you distributed
version control concepts to manage these conflicts and help to avoid them.

From your reading that was due today, you should understand the basics of
distributed version control with Git and what branches are. In large teams,
an effective way to isolate developer changes from other team members is to
use feature branches. Each time a developer begins work on a new feature that
could potentially affect other developers or the state of the "master" branch
of the code, that developer creates a separate feature branch. The developer
can work independently and commit changes to this feature branch without worrying
about making changes that conflict with the changes made by other developers
in their feature branches.

For this in-class assignment, we are going to create a development scenario where
feature branches are essential. We are going to take a small application with a
tiny code base and every student in the class is going to make changes to that code
base. Luckily, all of the changes are going to be made in separate feature branches
so that they do not conflict with each other. The individual teams are then going
to be responsible for merging ~15 of these feature branches into a single
master branch for their group that compiles and passes all of the tests.

A good process is going to be essential to making all of this work. Before the merging
starts, teams are going to have time to plan their merging strategy. It is essential
that you use this time very wisely and think carefully about how you are going to both
merge all of the branches and distribute the merging workload across your team members.
The completely merged branches that compile and pass the tests are due before the next
class. If you have an effective merging strategy, you should be able to complete the
assignment by the end of class and have no homework. If your merging strategy isn't
thought through carefully, the assignment is going to take MUCH longer and your team
will have homework.

## Part 0 - JUnit Tests

JUnit is a framework for writing tests of your code. JUnit provides a very simple
interface for developers, you simply create a class with methods named testXYZ
and annotate those methods with @Test. Each time that you right-click on a test
class and Run As->JUnit, JUnit automatically discovers and runs each of these
methods annotated with @Test. Inside of these test methods, you define your logic
for the test and check that one or more conditions are met by adding assertXYZ
statements, as shown below:

   ```java   
	package org.magnum.cs278.testdriven;

	import static org.junit.Assert.*;
	import org.junit.Test;

	public class TestAddition {

        // A simple test method
		@Test
		public void testTwoPlusTwoEqualsFour() {
			int sum = 2 + 2;
			
			// An assertion that is being checked
			assertEquals(4, sum);
			
			// This will fail and generate an error in JUnit
			assertTrue(sum == 5);
		}

	} 
   ```
In this simple test, the "testTwoPlusTwoEqualsFour()" method will be invoked and JUnit
will check all of the assertions. You can add JUnit tests in Eclipse by creating
new classes in the project by right-clicking on a package in src/test/java, 
New->Other->Java->JUnit->JUnit Test Case. Eclipse will automatically generate a barebones
test for you. You can then add as many testXYZ methods annotated with @Test as you want.

## Part 1 - Creating New Features

You have been assigned to a team in the class dashboard. Please 
assemble your team and begin the assignment. You should start by
completing the following steps:

1. Each team member should clone this repo: https://github.com/cs27x/in-class-2
   and import the in-class-2 project into Eclipse as a Gradle project. Do not 
   import the entire repository into Eclipse.
2. The team should dream up N new features, where N = Floor(total members / 2),
   for the application. Each individual feature should be implementable by a fellow classmate
   in 5min or less.
3. Each team must select a 3rd party library that will be used in at least 2 of their features
   and add this library to build.gradle.
4. For each feature, one team member (e.g., each feature is assigned to a different person) 
   must implement a JUnit test for the
   feature. The JUnit test __SHOULD NOT COMPILE AND/OR FAIL__ due to the missing implementation. 
   Creating a test before writing the actual implementation is known as test-driven
   development. For example, you might create the following test for a new feature 
   to only display park permits after a particular date:

   ```java   
	package org.magnum.cs278.testdriven;

	import java.util.List;

	import static org.junit.Assert.*;
	import org.joda.time.DateTime;
	import org.junit.Test;

	public class FilterParkPermitsAfterDateTest {

		private App app = new App();
	
		@Test
		public void test() {
			DateTime now = DateTime.now();
			List<Event> events = app.getParkSpecialPermitsAfterDate(now);
		
			for(Event event : events){
				assertTrue(event.getDateTime().isAfter(now));
			}
		}
	} 
   ```
   
   The "app.getParkSpecialPermitsAfterDate(now);" line would generate a compile
   error because that method doesn't exist yet and is part of the feature that
   is being tested. This is part of test-driven development. You write the test
   before writing the code to pass the test. The test, although it doesn't
   compile yet, defines the expected behavior of the feature and its API / 
   interface. 
     
5. Each team member that created a test for one of the features should now commit
   the test to a new branch in the repository named:
    "/feat/firstname_lastname/groupX", where firstname is the test creator's first
    name without any middle initials, lastname is their last name without any 
    IIs, IIIs, etc., and groupX is replaced by the group number (e.g., group2).
    
    Example:  /feat/jules_white/group2
    
    After you have committed your changes to the new branch, you must push the branch
    to the remote repository so that it is accessible to other developers. If you create
    the branch with:
    
    git checkout -b /feat/jules_white/group2
    
    You would then push the branch to the remote repo with:
    
    git push -u origin /feat/jules_white/group2
    
6. When your group is done, please announce it.

## Part 2 - Implementing the Behavior Defined in the Tests

1. When all of the teams are done, each team will be assigned another team's features
   to implement.
   
2. Each team member that did not implement a test will now implement the code / changes
   needed to pass the test produced by the other team. If there are syntax or other errors
   in the test that are not related to non-existant code (e.g., someone forgot a semi-colon),
   you should comment on the issue and fix it. You should implement only the code needed
   to make the test pass. For the previous test, you might add this code to the App
   class:

   ```java     
   	public List<Event> getParkSpecialPermitsAfterDate(DateTime now) throws Exception {
		List<Event> toDo = new ArrayList<Event>();
		List<Event> evts = getParkSpecialPermits();

		for (Event evt : evts) {
			if (evt.getDateTime().isAfter(now)) {
				toDo.add(evt);
			}
		}

		return toDo;
	}
   ```
   
3. When you are done with the implementation and the test passes, you should commit your
   changes to a new branch "/impl/test_creator_firstname_lastname/firstname_lastname/groupX"
   and push the branch to the remote repo. If Bob Jones created the test
   that Jules White is implementing and Jules is on team 3, he would use the branch:
   
   /impl/bob_jones/jules_white/group3
   
4. When all of the features assigned to your team have been implemented, please announce
   that your team is done.
   
## Part 3 - Designing a Merge Strategy
   
At this point, we should see ~30 branches like:

feat/jules_white/group1

feat/joe_porter/group2

impl/jules_white/joe_porter/group2

impl/joe_porter/jules_white/group1

...

Your team should create a groupX_master branch and push it to the remote repo. After
adding this branch to the remote repo, do the following:

1. Take 5min to define a process for merging the ~15 "impl" branches into your master
   branch. Your strategy should be fair and not simply be "Jennifer will do it." 
   Grading on the assignment will consider individual contributions to the team.
2. Take 3min to draw your strategy on the board
3. When you are done, we will discuss the strategies

## Part 4 - Merging

Use your strategy to completely merge the code into your groupX_master
branch and get all of the tests to pass. 

## Part 5 - Refactoring

Each team member should suggest one refactoring [http://martinfowler.com/books/refactoring.html] 
or improvement to the merged code. Each refactoring should be "suggested" by creating a branch named
"refactoring/firstname_lastname/groupX", applying the suggested refactoring, pushing the
branch to the remote repo, and then opening a pull request [https://help.github.com/articles/using-pull-requests]
for your teammates to review the refactoring. Your team should devise and use a process for 
reviewing and merging these pull requests into its groupX_master branch. Someone other than the
creator of the pull request must merge it. One way to accomplish this would be to have all team members
submit their pull requests and then stop and discuss each one as a group before merging it.

At the end of Part 5, all of the teams should have merged all of the features into their groupX_master
branches and refactored these branches via merging a series of pull requests from submitted by each
team member. Each team will have successfully emulated a large team-based software development,
integration, and refactoring process in a super-condensed timeframe. Every team member should have gained
basic familiarity with Git, testing, implementing features, merging / integrating work, and refactoring
to fix inherent inefficiencies that show up in distributed development. 

__Question: How hard would it have been to integrate these features and refactor without tests?__

