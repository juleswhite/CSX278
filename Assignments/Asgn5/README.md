## Elasticsearch, Logstash, and Kibana Reading (before 10/6)

What the stack is from the creators:

- [Kibana](https://www.elastic.co/products/kibana)
- [Elasticsearch](https://www.elastic.co/products/elasticsearch)
- [Logstash](https://www.elastic.co/products/logstash)

Using the stack:

- [The Complete Guide to the ELK Stack](http://logz.io/learn/complete-guide-elk-stack/)
- [Logstash Tutorial: How to Get Started](http://logz.io/blog/logstash-tutorial/)
- [Using Kibana for the First Time](https://www.elastic.co/guide/en/kibana/3.0/using-kibana-for-the-first-time.html)
- [Elastic Search 101](http://joelabrahamsson.com/elasticsearch-101/)


### Acknowledgements

The preliminary reading material comes from the creators of the ELK stack.

Reading was also selected based on the [recommendations](http://logz.io/blog/10-resources-you-should-bookmark-if-you-run-your-own-elk-stack/) of Daniel Berman, who works at Logz.io, which is a log platform built on the ELK Stack.

The other articles selected were written by people with extensive experience using the ELK Stack. Asaf Yigal is the co-founder of Logz.io, which is based on the ELK Stack. Jurgens du Toit also works at Logz.io and works extensively with Logstash and Elasticsearch.

### Assignment Spec

#### Before Class

##### Goals
1. To setup Logstash, Elasticsearch, and Kibana on your machine
2. To run each application to make sure it is operating

##### Installing ElasticSearch
1. Download the ElasticSearch Zip from https://www.elastic.co/downloads/elasticsearch
2. Extract the files from ElasticSearch and put them on your desktop or another easily accessible folder
3. Open your Command Prompt and type ‘curl --version’. If this command fails, git is not in your system’s path. Research how to add a command to your system’s path (this should not be a problem on Mac)
4. Using your Command Prompt, navigate to the  elasticsearch-2.4.0/bin/ folder and type `./elasticsearch.bat` (Windows) or `./elasticsearch` (Mac)
5. The server should be running! You’re now ready to begin the tutorial. Open another command window(leave the previous one open) and you can start querying the database.

###### Check ElasticSearch

Before class, start the server and run `curl -X GET http://localhost:9200` in a different command window. Send the resulting JSON to a Ashley Peck (ashley.m.peck@vanderbilt.edu) before class to show you have Elasticsearch setup.

##### Installing Kibana

1. Download Kibana Zip from https://www.elastic.co/guide/en/kibana/current/setup.html
2. Extract the files from Kibana and put them on your desktop or another easily accessible folder
3. Navigate the kibana bin folder and type `./kibana.bat` for windows or `./kibana` for Mac

###### Check Kibana

Before class, start the Kibana server and navigate to localhost:5601 in a browser. Include a screenshot of this in your email to Ashley.

##### Installing Logstash

Note: for the purposes of this assignment, Logstash does not need to be installed independently as the JHipster Console will download it for you in the second part of the assignment. Instructions for installation are included below if you want to use the ELK stack independent of this project.

1. Download Logstash Zip from https://www.elastic.co/downloads/logstash
2. Create a .conf file specifying inputs, filters and outputs
3. Navigate to the directory containing the extracted logstash files
4. Run `bin/logstash.bat agent -f logstash.conf` on Windows or `bin/logstash agent -f logstash.conf` (Where logstash.conf is the .conf created earlier)

#### Part 1 (In class) - Intro to Elasticsearch and Kibana

##### Goals:

1. To familiarize yourself with the JSON data format used with Elasticsearch
2. To learn how to create and populate an index in Elasticsearch
3. To learn how to query an elasticsearch database (including filtering results)
4. To learn how to change the mapping of an index in Elasticsearch
5. To learn how to delete a document and an index in Elasticsearch

##### Setup:

The first thing we need to do is start up our instance of Elasticsearch.  Use the terminal to navigate to the bin folder within the Elasticsearch folder you downloaded.  Once you are in this folder, run the `elasticsearch` executable (or the `elasticsearch.bat` executable if you are on Windows).  You should see it begin setup.  After it finishes, you can communicate with your Elasticsearch instance through a REST-based API on localhost port 9200.

We will be using a dataset of James Bond movies throughout this portion of the assignment.  The first step is to place all of the movies into an index.  A table of the movies can be found in the “Box Office and Budget” table here: https://en.wikipedia.org/wiki/List_of_James_Bond_films.

##### Step 1: Creating, Populating, and Deleting an Elasticsearch Index

1. Create an index called “bond_movies”
2. Populate the index with all of the bond movies found in the table (Hint: use “put” commands).  Include the following information for each: title, year produced, bond actor, director.
3. Create a new index called “test” and populate it with one document of your choosing.  Then delete this new document from the index.

##### Step 2: Writing Elasticsearch Queries

1. Write a query that returns all of the movies
2. Write a query that returns the movie with an ID of 1
3. Write a query that returns all movies that have the word “kill” in the title
4. Write a query that returns all movies made in 1967
5. Write a query that returns all movies made in 1967 with the word “Casino” in the title

##### Step 3: Intro to Kibana:

1. Start up your Kibana instance (follow the above Elasticsearch instructions only for the Kibana folder).
2. Point your browser to “localhost:5601”.  This should take you to the Kibana dashboard.
3. Create a visualization that shows what percentage of bond movies have Sean Connery starring as James Bond.  Add that visualization to your dashboard.

#### Part 2 - Using the ELK Stack with Log Data

##### Goals
The goal of this assignment is to learn how to use the JHipster Console to monitor the performance and logging of a JHipster service. This console uses the ELK stack, and it is much easier to implement than trying to implement each layer of the stack independently.

##### Installation
 This project will build on the JHipster Microservice Team's project. Copy your project from your Solutions/Asgn4 directory into a folder called "Part2" in your Solutions/Asgn5 directory. After you have done that, carefully read through The [JHipster Console Installation Instructions](https://jhipster.github.io/monitoring/) to get JHipster up and running.
 
###### Necessary Changes

First, you need to set up your microservice project to enable logging. There are 2 places in "src/main/resources/config/application-dev.yml" that you need to change to `enabled: true`. These are indicated at the webpage above.

Next, make sure the root of your project contains a file called `docker-compose.yml`. This file should be included by JHipster microservices setup, but if you do not have it or are having to use a monolith due to gradle errors, you can find that file [here](https://raw.githubusercontent.com/jhipster/jhipster-console/master/bootstrap/docker-compose.yml).

Now, open up the docker terminal and run `docker-machine ip`. This indicates the ip address your JHipster console will be availible on. Open up `application-dev.yml` again and change `host: localhost` to `host: your_ip` under jhipster.logging.logstash. 

All appropriate changes have been made, so to view the console simply start the console by navigating to the directory with the docker-compose.yml file in your docker terminal and running `docker-compose up`. Then, start the microservice by running `./gradlew bootrun` from a different terminal in the same directory. You can find the console at your_ip:5601.


### Team Members

- Malla,Janak
- Nguyen,Amy
- Peck,Ashley M
- Kim,Kyuhoon
- Quinones,Peter J
- Dubashi,Arjun
- Zhan,ZeJian
- Hurd,Sam P

