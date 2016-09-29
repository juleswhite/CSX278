# Spring Boot Exercise 

First, clone this Git repository and import it into Eclipse as a Gradle
project.

To run the application:

Right-click on the ExerciseApplication class in the edu.vanderbilt.spring
package, Run As->Java Application

To stop the application:

Open the Eclipse Debug Perspective (Window->Open Perspective->Debug), right-click on
the application in the "Debug" view (if it isn't open, Window->Show View->Debug) and
select Terminate

## Overview

A popular use of cloud services is to manage media that is uploaded
from mobile devices. This assignment will create a very basic application
for uploading video metadata to a service and managing existing metadata.
The exercise will use Spring Boot, a Java framework for building robust
web applications. JHipster generates Spring Boot code, so understanding
this exercise will help you to understand the code that JHipster generates
for you in the next assignment.

## Provided Code

The skeleton you were provided has some basic functionality for the video service. The 
VideoService class is a basic Spring controller that can handle
HTTP requests. Any class that has the @RestController annotation, such as the VideoService class,
will automatically be discovered by Spring. Spring then maps HTTP requests
to the various methods of the controller using the data in the @RequestMapping annotations.

For example, the following method maps HTTP GET requests to "/video/somenumber" to
the getVideo() method:

```

	@RequestMapping(value="/video/{id}", method=RequestMethod.GET)
	public Video getVideo(@PathVariable("id") Long videoId){
		return videos_.findOne(videoId);
	}

```

Whenever a client, such as a browser, sends an HTTP GET request to the server, it
will invoke this method. The @PathVariable annotation tells Spring to look at the
number provided in the path (e.g., id) and convert it to a Long to pass into the
method. The method is executed like any other Java method. However, the return 
value of the method will automatically be converted to JSON and sent back to the client.

__Try This:__ Add a System.out.println("id:"+videoId); statement to the getVideo()
method and then open your browser to http://localhost:8080/video/1. Try varying the
number passed in for the ID and see how it changes the printed message.

You can add additional requests that your server can handle by adding new methods
and annotating them with @RequestMapping. 

__Try This:__ Try adding a new method called "myTest"
that takes no parameters and annotate it with a @RequestMapping so that it receives
GET requests to the "/test/foo" path. You can have the method return a String like "Test"
so that you get a result when accessing the "/test/foo" path.

This example uses an Object Relational Mapping (ORM) framework called JPA to store
data to a database. The project is setup to use an embedded in-memory database called
H2. You can store and retrieve objects from this database using the simple interface
provided by JPA.

The Video and VideoRepository class are setup to store / retrieve data from the database.
Let's create some data to store in the database by running the following command from
either your Git Bash Shell or a terminal:


    curl -XPOST http://localhost:8080/video -d '{"id":-1}' -H "Content-Type:application/json"

The result of running the command should look something like this:

   [{"id":1}]
   
Try opening your browser to http://localhost:8080/video/1

If you look at the addVideo() method, you will see that it was invoked when we issued our
curl command (curl is a tool for sending HTTP requests). Spring took care of automatically
converting the JSON that we sent it into a Video object and passing it into our addVideo()
method as a parameter. The @RequestBody annotation told Spring to take the body of the request,
which was {"id":1} and convert it into a Video.

__Try This:__ Open up the Video class and try adding some additional member variables with 
associated getter/setter methods. Then, use variations of the curl command above to create new videos. 
You can set the properties of the Video's member variables by changing the data in your request. 
For example, if you created a "name" member variable, you could set it with a curl request like this:

    curl -XPOST http://localhost:8080/video -d '{"id":-1, "name":"Rocky"}' -H "Content-Type:application/json"
    
Notice that the VideoService class is using the VideoRepository save() and findOne() methods to query data
from the database. Spring automatically creates an instance of the VideoRepository for you to make
saving data easier. 

## Instructions

Please extend the provided skeleton to implement the following
API:
 
GET /video
   - Returns the list of videos that have been added to the
     server as JSON. The list of videos does not have to be
     persisted across restarts of the server. 

     
POST /video
   - The video metadata is provided as an application/json request
     body. 
   - The video metadata should contain a name, size, genre, and
     URL (as a String) where the video is available online
     
POST /video/{id}
   - This method should update the existing video with the video metadata
     provided in the body of the HTTP request
     
     
GET /video
   - Should return the list of all videos
   
DELETE /video/{id}
   - Should delete the specified video
     
      
For each element of the API, you should implement at least one
corresponding test in the ExerciseApplicationTests class. 



