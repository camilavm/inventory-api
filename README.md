# inventory-api
Coding Challenge Backend Development - Extending The Star Wars API
# Read Me
The following application is a coding challenge backend development whitch the follow requirement:

* Consume the information from SWAPI (https://swapi.dev/documentation). Extend the data model and implement functionality to keep track 
of the number of units for starships and vehicles. This can be achieved by adding the count property

# Features:
* Allow to get the total number of units for a specific starship or vehicle. 
  Example: get how many Death Stars are in the inventory of starships.


* Allow to set the total number of units for a specific starship or vehicle.
Example: set the number Death Stars in the inventory of starships.


* Allow to increment the total number of units for a specific starship or vehicle.
Example: increment by x units the number Death Stars in the inventory for starships.
 

* Allow to decrement the total number of units for a specific starship or vehicle. 
Example: decrement by x units the number Death Stars in the inventory for starships.

# Getting Started


# Technologies:
### Requirements - need to install to run the project:
* Java 17 
* Lombok 
* Docker 
* MySql database

### Others
* Spring boot
* Spring data JPA
* Hibernate
* OpenFeign
* Hexagonal architecture


# Run the project
* Start docker running `docker-compose up --build` in the root of the project
* Clean and compile de project running `mvn clean install` in the root of the project
* Open the project in a IDE and run `InventoryApiApplication.java`


# Endpoints:
### Starships:
* Get the total number of units for a specific starship:
  GET `http://localhost:8080/starships/?search=Death Star`


* Set the total number of units for a specific starship:
  PATCH `http://localhost:8080/starships/set/?search=Death Star`
  With body: `{  "number_units": 10  }`

* Increment the total number of units for a specific starship:
  PATCH `http://localhost:8080/starships/increment/?search=Death Star`
  With body: `{  "number_units": 5  }`


* Decrement the total number of units for a specific starship:
  PATCH `http://localhost:8080/starships/decrement/?search=Death Star`
  With body: `{  "number_units": 1  }`


### Vehicles:
* Get the total number of units for a specific vehicle:
  Endpoint example: GET `http://localhost:8080/vehicles/?search=Sand Crawler`


* Set the total number of units for a specific vehicle:
  PATCH `http://localhost:8080/vehicles/set/?search=Sand Crawler`
  With body: `{  "number_units": 10  }`


* Increment the total number of units for a specific vehicle:
  PATCH `http://localhost:8080/vehicles/increment/?search=Sand Crawler`
  With body: `{  "number_units": 5  }`


* Decrement the total number of units for a specific starship:
  PATCH `http://localhost:8080/vehicles/decrement/?search=Sand Crawler`
  With body: `{  "number_units": 1  }`

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [OpenFeign](https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)

### Additional Links
These additional references should also help you:

* [Declarative REST calls with Spring Cloud OpenFeign sample](https://github.com/spring-cloud-samples/feign-eureka)

