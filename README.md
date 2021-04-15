# TheUltimateList



## Description

This application is used to demonstrate Spring Boot framework, maven, MVC, and REST APIs. The application currently uses 2 thrid party APIs,
1. [The Dog API](https://docs.thedogapi.com/)
2. [The Twitch API](https://dev.twitch.tv/docs/)

## Tech/Framework Used and Other Documentation

The backend uses java sdk 16, [This guide will help get java sdk 16 on your computer if you're using mac. Go to step 3](https://mkyong.com/java/how-to-install-java-on-mac-osx/#homebrew-install-a-specified-java-adoptopenjdk-on-macos)
*If you dont have java 16 installed you can change the version in the `pom.xml` file. Change `<java.version>your_version</java.version>`, `<source>your_version</source>` and `<target>your_version</target>`

```
<properties>
  <java.version>16</java.version>
</properties>
```


```
<configuration>
  <source>15</source>
  <target>15</target>
</configuration>
```

Spring version 2.4.4

MySQL version 8.0.19

[Naming a package guide](https://docs.oracle.com/javase/tutorial/java/package/namingpkgs.html)

[Follow this guide to get a local sql server set up using spring if you need help](https://spring.io/guides/gs/accessing-data-mysql/#initial)

[Guide for sql commands](https://dev.mysql.com/doc/mysql-getting-started/en/)

## Installation

Please follow these steps to run this application:

1. Install a local MySQL Server, `brew install mysql`
2. mysql.server start
3. pull the repository to a folder (Remember where this is)


## How To Use
 
If you didnt start a local MySQL server do so now by typing in terminal, `mysql.server start` 

There are 2 ways you can start this application,
   - opening the project using intellij and running TheUltimateList.main()
   - In terminal navigate to the root folder of the project and type, `mvn spring-boot:run`
 

Once its started you can access 2 different endpoints, one to get all the video games with the passed in name and one to get the breed of dog with the passed in name

You can search for video game titles by using the `/searchgames` API and passing a name query parameter
example : http://localhost:8080/searchgames?name=halo

You can search for dog breeds by using the `/dog` API and passing a name query parameter
example : http://localhost:8080/dog?name=husky


## Future Updates

More features to come:

 - user friendly frontend
 - Writing to the MySQL Server
 - Docker
 - Kubernetes
 - Coherence







