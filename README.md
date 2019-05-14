# Aus Post coding challenge

# Design / Architecture
I have chosen Spring Boot to create this application. The reason for choosing Spring Boot is its convention over configuration approach and ability to create standalone applications. Project structure was generated using Spring Initializr.

# Tech-Stack Used to build application:

1. Spring boot embedded Tomcat Server
2. In-Memory h2 Database (but can be used with any jdbc compliant database)
3. Spring Rest
4. Jackson : Java to Json mapping 
5. Unit Testing Persistence : JPA provided by Hibernate 
6. JUnit : Unit Test Framework 
7. Mockito : Mocking framework 
8. Maven : Build integration
9. Postman : testing Rest Services.

# Security Considerations / Assumptions:
1. Full OAuth based authentication/authorization was not implemented as it was out of scope for this excercise.	
2. REST services are secured using Spring Security with Basic Auth, which is hard coded for this application. But in a real world application it will be generated by implementing a UserDetailsService (or OAuth) etc.
3. Security services are provided by non-invasive http interceptors.

# Application Assumptions:

There is one to one mapping between a post code and Suburb.

# How to run this application
* Clone the git repo using following command

```git clone https://github.com/jyotiverma12/postCodeApp.git```
	
   This will create a folder postCodeApp in your current working directory.
* Execute command:

``` cd postCodeApp ```
* Compile code using following command

``` mvn clean install ```
* Run the application using following command

``` java -jar ./target/postCodeApp-0.0.1-SNAPSHOT.jar```
* Now application is started.

# Using application
* Create some entries using any Rest client (I have used Postman)
* endpoint URL: http://localhost:8080/api/add (or relevant EC2 instance URL)
	* http method= PUT
	* add following http header:
 		* key=Content-Type value=application/json
	* Go to authorization tab:
        * Select Basic Auth
	Username : admin Password: adminPass
	* Paste the following content to the body section then click send
```	
{
	"postCode":3037,
	"suburb":"Sydenham"
}
```

* Run the following endpoint to get **Suburb by post code** 
* endpoint URL: http://localhost:8080/api/getbypostcode/3037
	* http method=GET
	* add following http header:
 	* key=Content-Type value=application/json

click send and you should get the following results
```
{
    "postCode": 3037,
    "suburb": "Sydenham"
}
```
* Run the following endpoint to get **Postcode by suburb** 
* endpoint URL: http://localhost:8080/api/getbysuburb/Sydenham
	* http method=GET
	* add following http header:
 	* key=Content-Type value=application/json
click send and you should get the following results

```
{
    "postCode": 3037,
    "suburb": "Sydenham"
}
```

# Testing
JUnit coverage is provided for controller class(PostCodeController.java) only. There is no JUnit coverage for repository class(SuburbPostCodeRepository.java) methods as repository is just an Inteface and implementation is provided by JPA.


## Author
* **Jyoti Verma**