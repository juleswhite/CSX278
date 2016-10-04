## JHipster Microservices Reading (Before 10/4)

- [An in depth look at why microservices are useful and some of their drawbacks](http://martinfowler.com/articles/microservices.html)
- [Another perspective on the monolithic architecture](http://microservices.io/patterns/monolithic.html)
- [Another perspective on the microservice architecture](http://microservices.io/patterns/microservices.html)
- [The JHipster documentation for using microservices in applications](https://jhipster.github.io/microservices-architecture/)
- [A simple video tutorial on creating microservice apps](https://www.linkedin.com/pulse/jhipster-quick-demo-how-create-microservices-gateways-victor-gil)
- [A straight-forward guide on creating a microservice project with JHipster](https://docs.google.com/document/d/1Wxo43oJgp4XP-C72pIbT-cjV0S4OlAHHAxxt7bgXFHw/edit#heading=h.3bpe7usu47rb)

## Software Install Instructions
JHipster and Docker should be installed from the previous 2 assignments. 
There is no additional software to install.

## Assignment Specification

For this assignment we will create a simple web app that provides a simple blog functionality. 

It will have two microservices: one managing person data, and the other managing blog data. 
It will also have a gateway for users to interact with. 

### Troubleshooting
#### Windows Users

- If you run into an error while running the **./gradlew -Pprod bootRepackage buildDocker** command that looks like:

		*"Unable to process incoming event 'Progress Complete'"*

	You can fix this by instead running the command **./gradlew --console plain -Pprod bootRepackage buildDocker**

### Helpful Commands
Here are some helpful commands that aren't mentioned in the assignmnet's reading:

- // stop all running containers
	**docker stop $(docker ps -a -q)**

- // remove all containers
	**docker rm $(docker ps -a -q)**

These two commands are usefull if you make a typo or run into other issues, as they return the docker environment to a clean state. 
In particular, they can be helpful if you run into an error like the following: 

	*ERROR: for jhipster-registry  Cannot create container for service
	jhipster-registry: Conflict. The name "/jhipster-registry" is already
	in use*

### Assignment Steps: 

**__Make sure that you name everything exactly as stated in the spec for grading purposes__**

Create a new folder named MyMicroservices
Create a subfolder named docker-compose
Create a subfolder named MS1
Create a subfolder named MS2 
Create a subfolder named MyGateway


#### Person Microservice
Inside the MS1 folder, generate a new JHipster application with the following options:

- Microservice application
- Default name (press enter)
- Port 8081
- Default package
- Default authentication
- SQL Database
- MySQL Production Database
- H-2 Disk based persistence
- Use HazelCast for 2nd level cache hibernation 
- Gradle backend
- Elasticsearch
- No internationalization
- gatling testing

This microservice will keep track of people. 

Create a new Person entity with the following properties:
- Fields:
 - name (string with “required” validation)
 - age (Integer with validation minimum value of 18)
 - address (string with no validation)
- No DTO 
- no separate class 
- no pagination

Now build the microservice using the command 
gradlew -Pprod buildDocker

#### Blog Microservice
Inside the MS2 folder, generate a new JHipster application with the same options as the first microservice, but make sure that a unique port is being used (8082, for example). This microapp will store blog posts.

- Microservice application
- Default name (press enter)
- Port 8082
- Default package
- Default authentication
- SQL Database
- MySQL Production Database
- H-2 Disk based persistence
- Use HazelCast for 2nd level cache hibernation 
- Gradle backend
- Elasticsearch
- No internationalization
- gatling testing

 
Create a new entity named "Blog: with the following properties:
- Fields
 - name (String with “required” validation 
- No Relationships with other entities
- No Data Transfer Object
- No separate service object (use the repo directly)
- No pagination

Create a new entity named "Entry" with the following properties: 
- Fields
 - title (String with “required” validation)
 - content (String)
 - date (LocalDate with “required” validation)
- Many to one relationship with the Blog entity
 - Use the "name" field from the Blog entity when displaying in AnglearJS
 - No validation rules
- No Data Transfer Object
- No separate service object (use the repo directly)
- No pagination

Now build the microservice application

#### Gateway
Inside the MyGateway folder, generate a new JHipster application with the following options:

- Microservice gateway
- Default Name (The name of the folder)
- Default port (8080)
- Default package
- Default authentication (JWT)
- SQL database
- MySQL implementation
- H2 development database with disk-based persistence
- HazelCast 2nd level cache hibernation
- Gradle backend
- ElasticSearch
- No LibSass preprocessing
- No internationalization support
- Gatling testing framework

This gateway will be the front end of the application. It will need to reference the entities stored in the microservices. 
Import the entities you created earlier in the two microservice applications (This is explained in the readings). 

Now build the gateway 

#### Docker Compose
Now go back to the docker-compose folder and run the Docker compose subgenerator. Use the default directory and add both microservices and the gateway. Don't use the JHipster console 
Run “docker-compose up -d” and you should be done. Check the port you used for the gateway and the app should be running.


#### Submission 
Look for a file named "docker-compose.yml" in your docker-compose directory. Add this file to your class github repo under the Asgn4 directory.


### Acknowledgement

Chris Richardson, the curator of microservices.io, is one of the leading 
consultants and educators regarding microservices. His writing on the 
architecture formed the basis of our understanding of the pattern.
Martin Fowler is a well known speaker regarding software patterns, 
and provides insight into the practical benifits and drawbacks of microservices.
We also used the JHipster documentation as a resource to learn about its 
integration into the JHipster generator.

### Team Members

- Jin, Bowen
- Snyder, Malcolm
- Lally, John L
- Lee, Albert
- Lee, Soo
- Lindner, Alec R
- Liu, Jiaqi
- Pettet, Geoff
