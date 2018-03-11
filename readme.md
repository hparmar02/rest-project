#Spring Boot "RestAPI" Example Project with in memory H2 database.

##How to Run
This application is packaged as a jar which has Jetty embedded. No installation necessary. You run it using the java -jar command.

* Clone this repository - git clone git@github.com:hparmar02/rest-project.git
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


Here are endpoints to call:

### GET HelloWorld

```
curl http://localhost:8080/helloWorld

Response: HTTP 200
Content: helloWorld 
```
### GET information from external endpoint.

```
curl http://localhost:8080/external

Response: HTTP 200
Content: JSON list 
```

### POST - Create Employee

```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "firstName": "testFirstName", \ 
   "lastName": "testLastName" \ 
 }' 'http://localhost:8080/employee/'
 
```

### GET Employee

```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/employee/testFirstName'

Response: HTTP 200
Content: Employee with firstName = testFirstName
```

### DELETE Employee

```
curl -X DELETE --header 'Accept: */*' 'http://localhost:8080/employee/testFirstName'

Response: HTTP 200
```

### To view Swagger 2 API docs

* Run the server and browse to http://localhost:8080/swagger-ui.html

### To view H2Console.
* Run the server and browse to http://localhost:8080/h2-console
* username: sa, password as empty - Click on Connect.
