# Attacker - Defender

## Overview

Cyber-security is a constantly evolving battle that requires software
engineers to continually learn what types of attacks are common and how
to mitigate those attacks. This exercise will require you to use one of
the best resources for software engineers to learn about cyber-security,
the Open Web Application Security Project (OWASP). OWASP provides an 
extensive taxonomy of common software flaws, how they are exploited, and
best design practices for avoiding them.

In this assignment, you will be learning about the top 10 security flaws
in web applications using OWASP's Top 10 Vulnerability List:

https://www.owasp.org/index.php/Top_10_2013-Top_10

After learning about the Top 10 common attacks on web applications, you will
compete in a game of attacker/defender to analyze a software code base for
flaws from the OWASP Top 10 list and then to identify mechanisms for fixing
the flaws. 

A popular use of cloud services is to manage media that is uploaded
from mobile devices. This assignment will use a very basic application
for uploading video to a cloud service and managing the video's metadata
to demonstrate the OWASP Top 10 security flaws. Once you are able to identify
the OWASP Top 10 flaws in this code base, you will have the core knowledge 
needed to identify flaws in much more sophisticated cloud services.

## Part 1 - Learning the Top 10 Web Application Vulnerabilities

In the first part of the exercise, you will have 20 minutes to study the
OWASP Top 10 list:

https://www.owasp.org/index.php/Top_10_2013-Top_10

Each team member should choose 2-3 vulnerabilities, learn how they are exploited,
and how they can be avoided. The team members should then take turns presenting
the vulnerabilities that they studied to the other team members and discussing 
them. When each team feels that it is ready, the team should call the instructor
over to ask them 5 questions about the top 10 vulnerabilities. 

Finally, after the questions are answered, each team member should fill out the
software & security habits survey:

http://goo.gl/forms/46KBIECVCS

## Part 2 - Attacker - Defender

For the second part of the exercise, the teams will compete to identify and propose
fixes for the security flaws in the sample application. The rules of the game are
as follows:

   1. A team can identify a vulnerability by raising their hands and describing the
     vulnerability to an instructor
   2. Once a team has identified a vulnerability, they receive 1 point per minute until
     all other teams have identified that vulnerability
   3. Teams are allowed to disclose vulnerabilities to other teams, but the team that 
     the vulnerability is disclosed to must be able to describe and discuss the vulnerability
     with the instructor independently of the team that disclosed the vulnerability
   4. A team receives a bonus of 100 points for identifying 6 of the 10 OWASP flaws in
     the application
   5. A vulnerability dashboard will be kept on the board that will show the time when 
     each team identifies a vulnerability in each category
   6. The members of the winning team will receive a 20pt bonus on one quiz


## Sample Application Overview

First, clone this Git repository and import it into Eclipse as a Gradle
project.

To run the application:

Right-click on the LocalApplication class in the org.magnum.dataup
package, Run As->Java Application

To stop the application:

Open the Eclipse Debug Perspective (Window->Open Perspective->Debug), right-click on
the application in the "Debug" view (if it isn't open, Window->Show View->Debug) and
select Terminate

The application that you will be analyzing is vulnerable to 6 of the 10
OWASP flaws that you will study.

The HTTP API that is provided by the sample application is as follows:
 
GET /video
   - Returns the list of videos that have been added to the
     server as JSON. The list of videos does not have to be
     persisted across restarts of the server. The list of
     Video objects should be able to be unmarshalled by the
     client into a Collection<Video>.
   - The return content-type should be application/json, which
     will be the default if you use @ResponseBody

     
POST /video
   - The video metadata is provided as an application/json request
     body. The JSON should generate a valid instance of the 
     Video class when deserialized by Spring's default 
     Jackson library.
   - Returns the JSON representation of the Video object that
     was stored along with any updates to that object made by the server. 
   - **_The server should generate a unique identifier for the Video
     object and assign it to the Video by calling its setId(...)
     method._** 
   - No video should have ID = 0. All IDs should be > 0.
   - The returned Video JSON should include this server-generated
     identifier so that the client can refer to it when uploading the
     binary mpeg video content for the Video.
   - The server should also generate a "data url" for the
     Video. The "data url" is the url of the binary data for a
     Video (e.g., the raw mpeg data). The URL should be the _full_ URL
     for the video and not just the path (e.g., http://localhost:8080/video/1/data would
     be a valid data url). See the Hints section for some ideas on how to
     generate this URL.
     
POST /video/{id}/data
   - The binary mpeg data for the video should be provided in a multipart
     request as a part with the key "data". The id in the path should be
     replaced with the unique identifier generated by the server for the
     Video. A client MUST *create* a Video first by sending a POST to /video
     and getting the identifier for the newly created Video object before
     sending a POST to /video/{id}/data. 
   - The endpoint should return a VideoStatus object with state=VideoState.READY
     if the request succeeds and the appropriate HTTP error status otherwise.
     VideoState.PROCESSING is not used in this assignment but is present in VideoState.
   - Rather than a PUT request, a POST is used because, by default, Spring 
     does not support a PUT with multipart data due to design decisions in the
     Commons File Upload library: https://issues.apache.org/jira/browse/FILEUPLOAD-197
     
     
GET /video/{id}/data
   - Returns the binary mpeg data (if any) for the video with the given
     identifier. If no mpeg data has been uploaded for the specified video,
     then the server should return a 404 status code.
   

