# Overview

This midterm covers the material up through the Docker assignment. You
are free to use any online resources that you want to complete the midterm.
You are also free to use whatever language / frameworks that you would like
to implement the spec. You are not allowed, however, to work together.

If you use JHipster and JDL, the solution to this midterm is roughly 40
lines of code. If you use the JHipster command line to generate the
entities, the solution will require generating 5 entities. If you use
another language / framework, this midterm will probably require a lot
of work.

# Spec

Please implement an HTTP application that allows you to store information related to 
homework assignments, submissions, and grades. An overview of the required data model
is available here: https://dl.dropboxusercontent.com/u/2340553/data_model.png. The 
application should store the following entities and all fields should be required:

```
Homework 
  title 
  due (ZonedDateTime if using JHipster)

JSON Format:

  {
    "due": "2016-10-18T16:54:02.624Z",
    "id": 0,
    "title": "string"
  }


Student 
  name
  studentId // e.g., bobj10
  email 

JSON Format:

  {
    "email": "string",
    "id": 0,
    "name": "string",
    "studentId": "string"
  }

Instructor 
  name
  email

JSON Format:

  {
    "email": "string",
    "id": 0,
    "name": "string"
  }

Submission 
  date (ZonedDateTime if using JHipster)
  homework - the homework specification for the submission (a many to one relationship owned by Submission)
  student - the student that is submitting the homework (a one to many relationship owned by Student)


JSON Format:

  {
    "date": "2016-10-18T16:54:02.736Z",
    "homework": {
      "due": "2016-10-18T16:54:02.736Z",
      "id": 0,
      "title": "string"
    },
    "id": 0,
    "student": {
      "email": "string",
      "id": 0,
      "name": "string",
      "studentId": "string"
    }
  }

Grade 
  score // e.g., 92.6
  grader - the instructor that graded the submission (a many to one relationship with Instructor)
  submission - the submission that the grade is for (a one to one relationship with Submission)

JSON Format:

 {
    "grader": {
      "email": "string",
      "id": 0,
      "name": "string"
    },
    "id": 0,
    "score": 0,
    "submission": {
      "date": "2016-10-18T16:54:02.573Z",
      "homework": {
        "due": "2016-10-18T16:54:02.573Z",
        "id": 0,
        "title": "string"
      },
      "id": 0,
      "student": {
        "email": "string",
        "id": 0,
        "name": "string",
        "studentId": "string"
      }
    }
  }

```

This API should be provided an HTTP API through GET and POST requests to the following paths:

```
/api/instructors 
/api/students
/api/homework
/api/submissions
/api/grades
```

The GET request to each of these paths should return all entities currently stored on the 
server. The POST path should accept an HTTP request body that is JSON using the format
specified above in the data model (or your JHipster version's format). 

The API should also support GET and DELETE requests to the following paths:

```
/api/instructors/{id}
/api/students/{id}
/api/homework/{id}
/api/submissions/{id}
/api/grades/{id}
```

The GET request should return just the entity with the given id. The DELETE request should
delete the entity with the specified id from the server.

Your application must require a login to access any of these APIs and have a default account
with username "admin" and pass "admin". 

# Handing in Your Solution

You should package your solution as a Docker image and push it to Docker Hub under your account.
Your image must be runnable and able to launch your solution. For example, if your DockerHub 
account is "foobar", your repo is named "solutions", and your solution image is tagged "midterm",
then the following command should run your solution and expose it on port 8080:

```
  docker run -p 8080:8080 foobar/solutions:midterm
``` 

Hint: using JHipster will make this step take three commands. One command will build your container,
one will tag it, and one will push it to DockerHub.

When you are done, submit your Docker image and source code here:

https://goo.gl/forms/JmiUCIz9OZ2HO6TH2





