## JHipster Microservices Reading (Before 10/4)

- [An in depth look at why microservices are useful and some of their drawbacks](http://martinfowler.com/articles/microservices.html)
- [Another perspective on the monolithic architecture](http://microservices.io/patterns/monolithic.html)
- [Another perspective on the microservice architecture](http://microservices.io/patterns/microservices.html)
- [The JHipster documentation for using microservices in applications](https://jhipster.github.io/microservices-architecture/)
- [A simple video tutorial on creating microservice apps](https://www.linkedin.com/pulse/jhipster-quick-demo-how-create-microservices-gateways-victor-gil)
- [A straight-forward guide on creating a microservice project with JHipster](https://docs.google.com/document/d/1Wxo43oJgp4XP-C72pIbT-cjV0S4OlAHHAxxt7bgXFHw/edit#heading=h.3bpe7usu47rb)


## Assignment Specification 

Create a new folder called MyMicroservices
Create a subfolder called docker-compose
Create a subfolder called MS1
Create a subfolder called MS2 
Create a subfolder called MyGateway
Inside the MS1 folder, generate a new JHipster application with the following options

1. Microservice application
2. Default name (press enter)
3. Port 8081
4. Default package
5. Default authentication
6. SQL Database
7. MySQL Production Database
8. Default for Second-level cache
9. Elasticsearch
10. Gradle backend
12. No internationalization
13. No testing (press space to unchoose gatling)

This microservice will keep track of people. 

Create a new Person entity with the following properties:
- Fields:
 - name (string with “required” validation)
 - age (Integer with validation minimum value of 18)
 - address (string with no validation)
- No DTO 
- no separate class 
- no pagination

Build the microservice

Inside the MS2 folder, generate a new JHipster application with the same options as the first microservice, but make sure that a unique port is being used (8082, for example). This microapp will store blog posts.

1. Microservice application
2. Default name (press enter)
3. Port 8081
4. Default package
5. Default authentication
6. SQL Database
7. MySQL Production Database
8. Default for Second-level cache
9. Elasticsearch
10. Gradle backend
11. No internationalization
12. No testing (press space to unchoose gatling)


Create a Blog entity with the following properties:
- Fields
 - name (String with “required” validation 
- No Relationships with other entities
- No Data Transfer Object
- No separate service object (use the repo directly)
- No pagination

Create a Entry entity with the following properties: 
- Fields
 - title (String with “required” validation)
 - content (String)
 - date (LocalDate with “required” validation)
- Many to one relationship with the blog entity
 - Use the name as an id
 - No validation rules
- No Data Transfer Object
- No separate service object (use the repo directly)
- No pagination

Inside the MyGateway folder, generate a new JHipster application with the following options:

- Microservice gateway
- Default Name (The name of the folder)
- Default port (8080)
- Default package
- Default authentication (JWT)
- SQL database
- MySQL implementation
- H2 development database with disk-based persistence
- Default 2nd level cache
- Gradle backend
- ElasticSearch
- No LibSass preprocessing
- No internationalization support
- No testing framework

This gateway will be the front end of the application. It will need to reference the entities stored in the microservices. Import the entities you created earlier in the two microservice applications. Now build the gateway.

Now go back to the docker-compose folder and run the Docker compose subgenerator. Use the default directory and add both microservices and the gateway. Run “docker-compose up -d” and you should be done. Check the port you used for the gateway and the app should be running.



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
