# Overview

One of the most powerful ways to learn about software engineering is to build and ship a software product to real users. Unfortunately, it is not possible to build a product, find real users, and support it within the course of the semester (at least for mere mortals). This assignment is designed to give you the experience of shipping and supporting a real product, but in a much more condensed time frame.

For this assignment, your team will be building an assignment that the other students in the class will have to complete. Each team will select a topic from the list below and develop a set of learning materials for the topic (e.g., outside reading, exercises, etc.), an assignment to apply the topic, and a process for supporting the learning materials and assignment. Each team will be playing the role of instructor, grader, and mentor for their topic. Your fellow classmates will be your users.

Be warned, this assignment will be hard. Designing, building, shipping, and supporting a product is hard. You will be developing an educational product and shipping it to real students.

## Deadlines

  1. 8/31 -- Email sent to instructor with topic preferences as a sorted list and any rationale of why the instructor should select your team for a specific topic
  2. 9/8 -- Outside learning materials (with an acknowledgement section describing what outside advisers you used to select the reading material) sent to the course repo (must be outlined in a README.md file) as a pull request for "Assignments/AsgnX", where X is the assignment number for your topic listed below
  2. 9/11 -- Results of beta test of outside reading materials emailed to TA and instructor
  3. 9/12 -- Quiz emailed as a PDF to TA for feedback
  2. 9/13 -- Changes to reading materials based on instructor feedback on your pull request
  3. 9/18 -- Written assignment specification added to your README.md file and sent to the course repo as a pull request for "Assignments/AsgnX", where X is the assignment number for your topic listed below 
  4. 9/20 -- Results of beta test of assignment specification emailed to TA and instructor
  4. 9/23 -- Changes to written assignment specification based on comments in your pull request
  4. 9/23 -- Supporting code artifacts for your assignment, if any, sent to the course repo as a pull request for "Assignments/AsgnX/Code", where X is the assignment number for your topic listed below 
  5. 1-week prior to your assignment's launch in class -- Automated tests delivered to TA
  6. 1-week prior to your assignment's launch in class -- Software install instructions added to your README.md via pull request
  6. 1-week prior to your assignment's launch in class -- post your team's office hours on Piazza

## Topics
  1. JHipster - Assignment 2 in class on 9/27
  3. Docker - Assignment 3 in class on 9/29
  4. JHipster Microservices - Assignment 4 in class on 10/4
  5. Elasticsearch, Logstash, and Kibana - Assignment 5 in class on 10/6
  5. React - Assignment 6 in class on 10/18

## Applied Skills

  1. Requirements creation
  2. Estimation
  3. Knowledge transfer
  4. Support & maintenance
  5. Automated testing
  6. User acceptance testing
  7. Outside self-directed skill acquisition
  8. Managing software developers implementing a spec that you created

## Requirements for All Teams

  1. You must create or find up to a week's worth of outside learning material so that
     your classmates can master the topic.
  2. You must create an assignment that each classmate will complete so that they can
     apply their knowledge and demonstrate mastery of the material.
  3. Your assignment should take approximately 2-3hrs to complete so that it provides sufficient
     complexity to apply the knowledge but not so much complexity that it is burdensome.
  4. You must create a written specification for the assignment and commit it to the class
     Git repository so that your classmates can find it and work on it outside of class.
  5. You must create a set of automated tests that will be run against each classmate's solution
     to assess their mastery and application of the material. 
  6. You must create a hand-in process for the assignment that is based on Git. 
  7. Your automated tests must be delivered to the TA and run on their computer so that they
     can assess the assignment solutions.
  8. Your automated tests must produce a single file in the format of your choice that shows
     the number of tests that each classmate's solution passed so that the TA can assess
     how well your peers learned the material.
  9. Your assignment must be presented to the class by your team.
  10. The first 1.25hrs of your assignment should be completed in class as an in-class exercise
      that your team leads and supervises so that students can ask questions and get up to
      speed under your mentorship.
  11. Your team members should each help your peers get up to speed on the assignment so that
      they can ask questions and get answers.
  12. Your team members should not give any solutions away to your peers, but instead help guide
      them by pointing them to resources, answering questions in a different context, etc. so that
      their question is answered in a way that still allows them to solve the problem on their own.
  13. Part of the assignment must be completed outside of class so that classmates can
     apply the knowledge on their own.
  14. You must hold two office hour sections in the Featheringill Hall Atrium of an hour each so that classmates can get help
     while they are learning the material and while they are completing the assignment. 
  15. One of the office hour sections should be held 2-3 days before the outside reading materials
      are due so that students can ask questions about what they are reading.
  16. One of the office hour sections should be held the day after you present your assignment in class
      so that students can get help with any questions that come up when they try to complete the
      out of class components of the assignment. 
  17. You must provide practical knowledge -- everyone should be able to apply what they
      are learning through programming so that the knowlege is helpful to them.
  18. You must get advice on what outside reading materials to use and what assignment to give from
      an outside expert other than the instructor of the class so that you get a diversity of opinions
      on the outside material (hint: try posting to forums related to the framework, etc.).
  19. You must run a beta test of your outside learning materials before they are released to the class so that
      you can ensure that they are clear and will effectively help your classmates learn the material.
  20. You must run a beta test of your assignment before it is released to the class so that you know the
      assignment is clear, doable within the allotted time, is not too easy, and is interesting.
  21. One day before your assignment is released and up to one day after its due date, you must provide
      a four hour window each day where you commit to answer any of your classmates questions regarding your
      outside materials or the assignment on Piazza within 5 minutes so that people can get questions answered quickly. 
  22. Your window for answering questions must include at least 2hrs between the hours of 8am and 8pm so that
      your classmates don't have to stay up late to get help.
  23. If any flaws, ambiguities, or other issues are found in your outside learning materials or assignment, 
      you must go into "all hands on deck" mode, fix the issue as fast as possible, announce the fix to your
      classmates, and provide extensive help to any of your peers that are negatively impacted by the issue
      so that your peers are not roadblocked or hurt by your mistake.
  24. You must produce a quiz that is coding oriented that can be completed in 20 minutes by your peers to
      demonstrate knowledge of the material and deliver the quiz in Word format to the TA so that they can
      give it if they choose to at some point in the course.   
  25. Realize that these requirements may be vague, contradictory, insufficient, or otherwise flawed and that
      EARLY interaction with the TA or instructor to clarify them is essential.
  26. Be prepared to accept requirement changes throughout the assignment.

## Topic-specific Requirements

### JHipster

  1. The assignment must include completion of a functioning Spring Boot application that stores data using
     a persistent database so that it is easy to setup and run on a classmate's computer.
  2. The assignment must include creation of at least two entities with relationships to other entities so
     that your classmates know how to create relationships in JHipster.
  3. The assignment must include the use of JDL-studio so that your classmates can use a UML-like language
     to model their database entities.
  4. The outside materials must include information on UML class diagrams so that the JDL-studio diagrams
     will make sense to your classmates.
  5. The assignment must include some component that requires looking at or analyzing the Swagger documentation
     generated by JHipster so that your classmates will know how to create and consume HTTP API documentation.
  6. You must create a set of instructions on how to install and setup JHipster that your classmates must complete
     before your assignment is released in class so that the in-class component of the assignment is not dedicated
     primarily to installing JHipster on everyone's laptop.
  7. You must track who completed the JHipster setup prior to class and provide this list to the TA so that 
     we can use it for grading purposes.
  8. You must post your installation and setup instructions in the class' Git repo along with your outside
     learning materials.
  9. Your assignment must require students to create a JHipster proejct from scratch so that they can quickly
     prototype a Java-based server on their own in the future.
  
### Elasticsearch, Logstash, and Kibana

  1. The assignment must include the collection of performance metrics from the assignment solutions to the
     JHipster Microservices team's project so that students learn to monitor the server applications that they create.
  2. The assignment must include the collection of log statements from the assignment solutions to the
     JHipster Microservices team's project so that students learn to setup centralized logging of the server applications 
     that they create.
  3. The assignment must include the creation of at least 3 different types of visualizations on a dashboard
     using Kibana.
  4. You can use either a local installation of Elasticsearch and Kibana, a Dockerized version,  or the free trial of Elastic's 
     Cloud service so that you have flexibility in what students have to setup on their local machines.
  5. You must create a set of instructions on how to install and setup any locally installed software that your classmates must complete
     before your assignment is released in class so that the in-class component of the assignment is not dedicated
     primarily to installing a bunch of stuff.
  6. You must track who completed the software setup prior to class and provide this list to the TA so that
     we can use it for grading purposes.
  7. You must post your installation and setup instructions in the class' Git repo along with your outside
     learning materials. 
  8. You should look at the JHipster Console very carefully so that you can save yourself a ton of time.
  9. You should think about using the solution to the JHipster Microservices project but deleting the existing
     docker compose configuration and generating a new one with JHipster so that your life is MUCH easier.

### Docker

  1. The assignment must include creating a Dockerfile from scratch that packages the solution to the JHipster
     team's assignment into a container image that can be run with Docker so that your classmates know how to
     package their Java applications with Docker.
  2. The assignment must include launching more than one container with docker compose so that your classmates
     understand how to launch multiple containers that work together.
  3. You must create a set of instructions on how to install and setup Docker and Docker compose that your classmates must complete
     before your assignment is released in class so that the in-class component of the assignment is not dedicated
     primarily to installing a bunch of stuff.              
  4. Your installation instructions must support Linux, Windows, and OS X so that all of your classmates' platforms
     are covered.
  5. You must track who completed the software setup prior to class and provide this list to the TA so that
     we can use it for grading purposes.
  6. You must post your installation and setup instructions in the class' Git repo along with your outside
     learning materials. 
  7. The assignment must include searching for, finding, and using at least one existing container image on 
     DockerHub so that your classmates know how to find and use existing containers.
  8. The assignment must include setting up a DockerHub account and pushing at least one public container to
     DockerHub so that your classmates know how to publish containers for other people to use.

### JHipster Microservices
  
  1. The assignment must include the creation of at least two separate services that store entities in a persistent  
     database so that your classmates know how to create and compose multiple services.
  2. The assignment must include the creation of a gateway that provides a front-end for the services that 
     your assignment requires creating so that your classmates know how to generate a UI for existing services.
  3. The assignment must NOT include the JHipster Console, but you might want to tell the Elasticsearch team
     about it and coordinate with them in some fashion so that you can save them some time.
  4. Your assignment should include using docker compose to launch all of the services and a JHipster Registry
     so that your classmates know how to launch and manage multiple microservices.
  5. Your outside reading must include some basic information on what microservices are and the pros/cons
     of them so that your classmates have some idea of the point of what they are doing.  

### React
   
  1. Your assignment must build on the JHipster team's assignment solution and create a React UI for
     CRUD operations on one of the entities so that your classmates know how to build a UI for an existing HTTP API.
  2. Your assignment must include creating tests for the UI so that your classmates know how to test
     their front-end code. 
  3. You must create a set of instructions on how to install and setup any locally installed software that your classmates must complete
     before your assignment is released in class so that the in-class component of the assignment is not dedicated
     primarily to installing a bunch of stuff.
  4. You must track who completed the software setup prior to class and provide this list to the TA so that
     we can use it for grading purposes.
  5. You must post your installation and setup instructions in the class' Git repo along with your outside
     learning materials.
  


