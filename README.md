# TheUltimateList



## Motivation

This application is used to demonstrate spring boot framework, maven, MVC, and restful endpoints. Im currently using 2 APIS,
1. [The Dog API](https://docs.thedogapi.com/)
2. [The Twitch API](https://dev.twitch.tv/docs/)

More features to come include a user friendly frontend, writing to the mysql server, docker, kubernetes, coherence 

## Tech/Framework Used and Other Documentation

The backend uses java sdk 16, [This guide will help get java sdk 16 on your computer if you're using mac. Go to step 3](https://mkyong.com/java/how-to-install-java-on-mac-osx/#homebrew-install-a-specified-java-adoptopenjdk-on-macos)

Spring version 2.4.4

MySQL version 8.0.19

[Naming a package guide](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)

[Follow this guide to get a local sql server set up using spring if you need help](https://spring.io/guides/gs/accessing-data-mysql/#initial)

[Guide for sql commands](https://dev.mysql.com/doc/mysql-getting-started/en/)

## Installation

You will have to follow these steps to run this application:
1. Install a local [sql server](https://dev.mysql.com/downloads/mysql/) version 5.6 or better
2. mysql.server start
3. pull the repository to a folder (Remember where this is)


## How To Use

1. **HAVE TO DO BEFORE STARTING APPLICATION** If you didnt start a local MySQL server do so now using by typing, "mysql.server start" in termainl

There are 2 ways you can start this application,
   - opening the project using intellij and running TheUltimateList.main()
   - In terminal navigate to the root folder of the project and type, "mvn spring-boot:run"
 

Once its started you can access 2 different endpoints, one to get all the video games with the passed in name and one to get the breed of dog with the passed in name

### Example:

http://localhost:8080/searchgames?name=halo

http://localhost:8080/searchgames?name=god%20of%20war

http://localhost:8080/dog?name=husky

http://localhost:8080/dog?name=german

In the above examples you can set name to whatever you like








