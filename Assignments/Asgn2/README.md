# Assignment 2: JHipster 
## Introduction

JHipster is a free open-source application generator used to quickly develop modern web applications using AngularJS and the Spring Java Framework.

## Readings
+ [Intro to JHipster](https://spring.io/blog/2015/02/10/introducing-jhipster)
+ [JHipster Documentation](https://jhipster.github.io/)
-The whole website is useful, so make sure to explore the subpages (like their [video tutorial](https://jhipster.github.io/video-tutorial/), [creating an application](https://jhipster.github.io/creating-an-app/), and [creating an entity]( https://jhipster.github.io/creating-an-entity/) pages. 
+ [Bootstrapping Your Microservices Architecture with JHipster and Spring](https://blog.heroku.com/bootstrapping_your_microservices_architecture_with_jhipster_and_spring)
+ [Installing JHipster](http://www.uvionicstech.com/blog/development/jhipster-installation-and-build-guide/)
+ [UML](https://jhipster.github.io/jhipster-uml/)

### Acknowledgements
+ Most of our readings come directly from the JHipster documentation provided by the developers and creators of JHipster. Also, within the articles, are video guides created by the founder of JHipster, Julien Dubois. Aside from the video, most of the articles were written or updated in the last year, and though new versions have been released, the basics of JHipster have remained the same.

##Assignment 2 Spec: 

*Due Date: 9/27*

In this assignment, you will develop a simple student contact list consisting of a database of students using JHipster.

**Installing JHipster and other prerequisite software (to be done before class)**

*Note: Please make sure you have the latest versions of all software, or you will have many issues*

1. Install Node.js from [the Node.js website](http://nodejs.org/) (prefer an LTS version). This will also install npm, which is the node package manager we are using in the next commands.
2. Install Git from [the git site](https://git-scm.com/).
3. Install Yeoman: `npm install -g yo`
4. Install Bower: `npm install -g bower`
5. Install Gulp: `npm install -g gulp-cli` (If you have previously installed a version of gulp globally, please run `npm rm -g gulp` to make sure your old version doesn&#39;t collide with gulp-cli)
6. Install JHipster: `npm install -g generator-jhipster`


You may also choose to follow the guide linked [here](http://www.uvionicstech.com/blog/development/jhipster-installation-and-build-guide/).
Once completed, type `yo jhipster` into the command line, upload a screenshot of the output to any image-hosting website, and submit it via [this Google form](https://docs.google.com/forms/d/e/1FAIpQLSfGNnvSN1LOC54gLVoSsFfHPv6KHVt-dVgX_Elnq7dWBEMMpw/viewform)

 **Setting up your JHipster application (to be completed in class)**

1. First of all, create an empty directory in which you will create your application: `mkdir myapplication`
2. Go to that directory: `cd myapplication/`
3. To generate your application, type: `yo jhipster`
4. Answer the questions asked by the generator to create an application tailored to your needs.
For this project, we will be using the following setup configuration:
```
(1/13) Which *type* of application would you like to create?
Monolithic application (recommended for simple projects)

(2/13) What is the base name of your application?
<name>

(3/13) What is your default Java package name?
org.jhipster.com

(4/13) Which *type* of authentication would you like to use?
HTTP Session Authentication stateful, default Spring Security mechanism)

(5/13) Which *type* of database would you like to use?
SQL (H2, MySQL, MariaDB, PostgreSQL, Oracle)

(6/13) Which *production* database would you like to use?
MySQL

(7/13) Which *development* database would you like to use?
H2 with disk-based persistence

(8/13) Do you want to use Hibernate 2nd level cache?
Yes, with ehcache (local cache, for a single node)

(9/13) Would you like to use Maven or Gradle for building the backend?
Gradle

(10/13) Which other technologies would you like to use?
NONE

(11/13) Would you like to use the LibSass stylesheet preprocessor for your CSS
No

(12/13) Would you like to enable internationalization support?
No

(13/13) Which testing frameworks would you like to use?
NONE (deselect the default)
```

5. Ensure that all of your package managers loaded correctly: `npm install && bower install && gulp install`

At this point, if everything has been done correctly, you should be able to launch your application. Make sure that you don't have a processes running on the 8080 port.
Launch your app by typing:
>Windows users: run `gradlew` | Mac users: run `./gradlew`

Now navigate your browser to `http://localhost:8080`. Play around with the application for a while. Login as different types of users and see what you can find.

**Objective (to be completed at home)**

Design a contact list application which stores the following information about a student in each entry:

- Email
- Full Name
- Preferred Contact Method
- Phone number
- Graduation Date
- Dormitory
- School

**Creating and Importing JDL file**

In order to create a contact list, you will need to create entities, which represent elements of the contact, and indicate the relationships between them using JDL studio, found at [_https://jhipster.github.io/jdl-studio/_](https://jhipster.github.io/jdl-studio/). Keep in mind that when adding entities, you will want to be able to pick, for example, which school a student is in, not the ID of that school.

You should attempt to recreate the following entity heirarchy:

![jhipster-jdl.png](http://s9.postimg.org/v0h4lnmrz/pic.png)

*Note: Some of the labels on the diagram have been removed to make this part a bit more difficult. Please name your entities EXACTLY how they are named in the provided diagram. This helps a lot for grading.*

Now download your file, and rename it `First_Last_JDL.jh`. Move the file into the same folder as your project. To import the JDL file in your project, run command: `yo jhipster:import-jdl <filename>` and then rebuild to incorporate changes.

> If jhipster asks if you would like to overwrite any files during this process, answer yes.

**Building and running your JHipster application**

1. Windows users: run `gradlew` | Mac users: run `./gradlew`
2. Access your application at `http://localhost:8080`

*Note: If you already have a process running on port 8080, you will need to terminate that process before running your project.*

**Submission and Follow-Up**

To submit your assignment, simply upload your jdl file to your Asgn2 github. Please name your JDL file `First_Last_JDL.jh`

Now that you have a working application, explore it! Feel free to explore however you'd like, but here are some suggestions:

Login as either type of user and add some entities of each kind. Why do you have to do it in a certain order?
Look for the API page and navigate to some of the links in the drop-down menus. Do this both before and after you have added entities. What are the differences?



## Team members

+ [Neil Advani](mailto:neil.advani@vanderbilt.edu)
+ [Mohaimin Al Aoun](mailto:mohaimin.al.aoun@vanderbilt.edu)
+ [Marwan Aleasa](mailto:marwan.a.aleasa@vanderbilt.edu)
+ [Richard Arledge](richard.b.arledge@Vanderbilt.Edu)
+ [Steven Ayanruoh](mailto:steven.ayanruoh@vanderbilt.edu)
+ [Zachary Barton](mailto:zachary.m.barton@Vanderbilt.Edu)
+ [Brennan Belew](mailto:brennan.c.belew@vanderbilt.edu)
+ [Ellis Brown](mailto:ellis.l.brown@vanderbilt.edu)
+ [Caelan Collins](mailto:caelan.p.collins@vanderbilt.edu)