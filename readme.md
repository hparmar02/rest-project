#Spring Boot "RestAPI" Example Project

##How to Run
This application is packaged as a jar which has Jetty embedded. No installation necessary. You run it using the java -jar command.

* Clone this repository
* Make sure you are using JDK 1.8 and Gradle 4.x
* You can build the project and run the tests by running ./gradlew clean build
* Build will generate rest-project-0.0.1-SNAPSHOT.jar in build/libs directory
* Once successfully built, you can run the service as follows:

```
java -jar build/libs/rest-project-0.0.1-SNAPSHOT.jar
```
* Log file will be log/apiproject.log, please make sure not exceptions are thrown.

Once the application runs you should see something like this
```
2018-03-06 19:08:43.938  INFO 4592 --- [           main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@4b520ea8{HTTP/1.1,[http/1.1]}{0.0.0.0:8080}
2018-03-06 19:08:43.943  INFO 4592 --- [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port(s) 8080 (http/1.1) with context path '/'
2018-03-06 19:08:43.946  INFO 4592 --- [           main] c.p.restproject.RestProjectApplication   : Started RestProjectApplication in 3.695 seconds (JVM running for 4.168)
```


