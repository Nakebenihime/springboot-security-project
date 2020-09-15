# SPRING BOOT SECURITY BASIC CONCEPTS
This repository contains some basic security concepts using the springboot security dependency.
This repository has three tag versions (v1, v2, v3), each of them corresponds to a specific way to authenticate to the application.

v1 - BASIC HTTP AUTHENTICATION
- refers to a simple authentication scheme built into the HTTP protocol.

v2 - FORM-BASED AUTHENTICATION
- refers to the notion of a user to whom is given an editable "form" to be filled out and submitted to connect to any system or service.

v3 - JWT AUTHENTICATION
- similar to session id technologies - it refers to a secure token-based authentication.  

## TECHNOLOGY STACK
COMPONENT                           | TECHNOLOGY              | FOR MORE INFORMATION
---                                 | ---                     |---
Languages & Frameworks              |`spring boot`            | https://spring.io/projects/spring-boot
Databases                           |`mongoDB`                | https://www.mongodb.com/
Java Tools                          |`lombok` `maven`         | https://projectlombok.org/ & https://maven.apache.org/
User Management and Authentication  |`java-jwt`               | https://github.com/auth0/java-jwt
Security                            |`spring security`        | https://spring.io/projects/spring-security 

## PREREQUISITES
These instructions will allow you to get a copy of the project on your **windows** machine, you must have the following software correctly installed in order to build the project.

### INSTALL JAVA
1. visit [oracle.com](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html) official website
2. select the windows x64 installer
3. run the installer and follow the steps

Set a new "JAVA_HOME" variable under "advanced system settings" > "environment variables" and click "new system variable": 
```
variable name: JAVA_HOME
variable value: C:\Program Files\Java\jdk-14.0.2
```
In system variables, find PATH, click edit... button and add:
```
%JAVA_HOME%\bin
```
Open a command prompt window to verify the installation with the following command:
```
C:\Windows\System32> echo %JAVA_HOME%
C:\Program Files\Java\jdk-14.0.2

C:\Windows\System32> java -version
java version "14.0.2" 2020-07-14
Java(TM) SE Runtime Environment (build 14.0.2+12-46)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
```

####  INSTALL MAVEN
Maven is a build automation tool used primarily for JAVA projects.

1.	visit [maven.apache.org](https://maven.apache.org/download.cgi/) official website
2.	select the binary zip archive and extract it to you favorite location

Set two new variables under "advanced system settings" > "environment variables" and click "new system variable":
- first variable:
```
variable name: M2_HOME
variable value: C:\Program Files\apache-maven-3.6.3
```
- second variable:
```
variable name: MAVEN_HOME
variable value: C:\Program Files\apache-maven-3.6.3
```
In system variables, find PATH, click edit... button and add:
- first variable:
```
%M2_HOME%\bin
```
- second variable:
```
%MAVEN_HOME%\bin
```
open a command prompt window to verify maven installation with the following command:
```
C:\Windows\System32> mvn -v
Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\Program Files\apache-maven-3.6.3\bin\..
Java version: 14.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-14.0.2
Default locale: fr_FR, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows
```
For more instructions, visit [maven.apache.org](https://maven.apache.org/) official website.

## PROJECT STRUCTURE
```

```
## GETTING STARTED
clone the application, run the following command:
```
git clone https://github.com/Nakebenihime/springboot-security-project.git
```
Run the following command to list the git tags (three git tags must appear) :
```
git tag -l
v1.0.0-HTTPBASIC
v2.0.0-FORM-BASED-AUTH
v3.0.0-JWT-AUTH
```
You can now switch to each of the git tags using the following command:
```
git checkout v1.0.0-HTTPBASIC |OR| v2.0.0-FORM-BASED-AUTH |OR| v3.0.0-JWT-AUTH
```
Build the application with the following command:
```
mvnw clean package
```
Run the application with the following command:
```
java -jar boot-security-project-1.0.0-HTTPBASIC.jar |OR| java -jar boot-security-project-2.0.0-FORM-BASED-AUTH.jar |OR| java -jar boot-security-project-3.0.1-SNAPSHOT.jar
```
or run with maven command:
```
mvnw spring-boot:run
```
##EXPLORE THE APPLICATION
For each git tag (v1-...,v2-...,v3-...) you have three users (user, manager and admin); all these users have different roles/permissions in the application.

| USER                    | ROLES/PERMISSIONS                   | ACCESS 
---                       | ---                                 | ---                           
USER                      | USER / ""                           | profile/index;
MANAGER                   | MANAGER / "ACCESS_TEST1"            | profile/index & manager/index /api/public/test1;
ADMIN                     | ADMIN / "ACCESS_TEST1,ACCESS_TEST2" | profile/index & manager/index & admin/index & /api/public/test1 & /api/public/test2;