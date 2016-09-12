# Assignment 3: Docker 
## Introduction
Docker is a way to wrap a solution with all it's dependencies in a container as a lightweight alternative to virtual machines and solving problems like dependency hell and deployment optimization. In order to ramp up and be able to package solutions the following will be needed:

## Complete by 9/29
### Dependencies
+ Make an account in [Docker Hub](https://hub.docker.com/)
+ We assume you have read the [Bash shell tutorial](http://www.ee.surrey.ac.uk/Teaching/Unix/) from assignment 0 or that you are familiar with the basic Unix commands.
+ Install Docker:
    - If you are working on Linux, Mac, or Windows Professional, dowload the appropriate installer from [here](https://www.docker.com/products/docker#/windows) and follow the instructions.
    - If you have a Windows Home installation, make sure to download Docker from [here](https://www.docker.com/products/docker-toolbox) and make sure to choose the option to install VirtualBox as Docker needs virtualization in non-Linux systems. Everytime that you need to execute Docker commands in the command line make sure to run *docker-machine* to boot up the virtual machine in which Docker runs in your system. To make sure that it's setup correctly run *docker run hello-world*. In case it doesn't display 

    	> Hello from Docker!

    	There's a [troubleshooting](https://docs.docker.com/toolbox/faqs/troubleshoot/) section in the Docker documentation to configure the virtual machine.
+ Optional: Java, Python, and PiP are required if you want to 

### Readings
+ Work through the [Docker Documentation](https://docs.docker.com/engine/understanding-docker/) the steps in 'Get Started with Docker' to get the basics of Docker. If you are running on Windows make sure you are running the MINGW console (either the one install by Git or the one installed through Docker) as some of the commands are not available in powershell (such as touch).
	From his you'll learn:
	- How Docker works
	- Docker's purpose
	- Containers and images
	- How to push and pull images from Docker hub
	- How to build images from dockerfiles
+ Read through [Docker Compose](https://docs.docker.com/engine/getstarted/step_four/) to understand how to run multiple containers.
+ [This](https://www.youtube.com/watch?v=pGYAg7TMmp0) series of videos gives a good introductory explanation and a good series of examples on how to deploy and scale a service using Docker. Only required to watch the first three videos.
+ [This](https://prakhar.me/docker-curriculum/#prerequisites) is a very thorough explanation on how to deploy a whole web app to Amazon using Docker. Read through to understand usage how to use multiple containers using different techniques, port-forwarding, and how to search for existing images and services in Docker Hub. There's no need to follow the tutorial as many of the topics covered will also get covered by other groups, but reading it explains important usage cases for Docker.
+ Read the [JHipster documentation](https://jhipster.github.io/docker-compose/) on how to package a product from JHipster into a container. 

### Acknowledgements
+ The first reading is directly from the Docker documentations as a general overview of how to work with and how Docker works.
+ Integration with other tools is referred directly from documentations as they are from regularly updated packages.
+ [Prakhar Srivastav](http://prakhar.me/) is a grad student in Columbia University's CS department with one of the most complete crash courses on Docker listing many alternatives in his course. His GitHub repo for the course has active discussion on the issues of the course and is actively updated making it a reliable source as well as appearing in several Quora answers on the topic. 

## In-class assignment
+ (Installation of Docker will be verified in class through makeing them pull an image that will poll them for their ID's and will be stored in a DB).

## Team members
+ [Campbell, Grey](mailto:grey.e.campbell@vanderbilt.edu)
+ [Chung, Hoon Tae](mailto:hoon.tae.chung@vanderbilt.edu)
+ [Degroot, Max](mailto:alexander.m.degroot@vanderbilt.edu)
+ [Goggans, Connor A](mailto:connor.goggans@vanderbilt.edu)
+ [Hoyos Ayala, Juan Sebastian](mailto:juan.s.hoyos@vanderbilt.edu)
+ [Hua, Hongtao](mailto:hongtao.hua@vanderbilt.edu)
+ [Samost, Jonah](mailto:jonah.samost@vanderbilt.edu)
+ [Mbusa, Paul](mailto:paul.y.mbusa@vanderbilt.edu)
