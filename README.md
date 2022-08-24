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
Languages & Frameworks              |`springboot`             | https://spring.io/projects/spring-boot
Databases                           |`mongoDB`                | https://www.mongodb.com/
Java Tools                          |`lombok` `maven`         | https://projectlombok.org/ & https://maven.apache.org/
User Management and Authentication  |`java-jwt`               | https://github.com/auth0/java-jwt
Security                            |`spring security`        | https://spring.io/projects/spring-security 

## PREREQUISITES
These instructions will allow you to get a copy of the project on your **windows** machine, you must have the following software correctly installed in order to build the project.

- [JAVA](https://mario-dacosta.gitbook.io/nakebenihime/tutorials/java-technology-framework-and-tools/openjdk/how-to-install-openjdk-on-windows)
- [MAVEN](https://mario-dacosta.gitbook.io/nakebenihime/tutorials/java-technology-framework-and-tools/apache-maven/how-to-install-apache-maven-3.8.x-on-windows)

## GETTING STARTED
Clone the application, run the following command:
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
Generate a keystore:
```
keytool -genkeypair -alias bootsecurity -storetype PKCS12 -keyalg RSA -keysize 2048  -keystore bootsecurity.p12 -validity 3650
```
Configure SSL properties:
```
server:
port: 8443
ssl:
enabled: true
key-store: src/main/resources/bootsecurity.p12
key-store-password: bootsecurity
key-store-type: PKCS12
key-alias: bootsecurity
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
For each git tag (v1-...,v2-...,v3-...) you have three users (user, manager and admin); all these users have distinct roles/permissions in the application

| USER                    | ROLES/PERMISSIONS                   | ACCESS 
---                       | ---                                 | ---                           
USER                      | USER / ""                           | profile/index
MANAGER                   | MANAGER / "ACCESS_TEST1"            | profile/index & manager/index /api/public/test1
ADMIN                     | ADMIN / "ACCESS_TEST1,ACCESS_TEST2" | profile/index & manager/index & admin/index & /api/public/test1 & /api/public/test2

## cURL - v3.0.0-JWT-AUTH

Retrieve JWT access token (change username and password to have alternate authorities and roles)
```
curl --location --request POST 'https://localhost:8443/login' \
--header 'Content-Type: application/json' \
--data-raw '{
"username":"user",
"password":"user123"
}'
```

GET test1 (resource available to all the authenticated users)
```
curl --location --request GET 'https://localhost:8443/api/public/test1' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjA4NDA2NTkyfQ.dWptNWtBsvYC01IxRCuilkK1GaTy1ZQCbrk5lidGs4RYtI-RQkOKwYbyKeVeKgahtuWagAFtkXdIAy5Rt4CKwA'
```

GET reports (resource available to managers)
```
curl --location --request GET 'https://localhost:8443/api/public/manager/reports' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjA4NDA2NTkyfQ.dWptNWtBsvYC01IxRCuilkK1GaTy1ZQCbrk5lidGs4RYtI-RQkOKwYbyKeVeKgahtuWagAFtkXdIAy5Rt4CKwA'
```

GET users (resource available to admins)
```
curl --location --request GET 'https://localhost:8443/api/public/admin/users' \
--header 'Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNjA4NDA2NTkyfQ.dWptNWtBsvYC01IxRCuilkK1GaTy1ZQCbrk5lidGs4RYtI-RQkOKwYbyKeVeKgahtuWagAFtkXdIAy5Rt4CKwA'
```
