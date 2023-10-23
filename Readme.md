# USER MANAGEMENT SYSTEM

**Name: Pankaj Kalra, Batch: FS-11**
[GITHUB](https://github.com/Pankaj-dev98/restaurant-management-service-geekster)

## Frameworks and languages used
- Source code: Java 21
- Base framework: SpringBoot with inbuilt TomCat server
- Dependencies: spring-boot-starter-web, Spring data JPA, Spring-boot-dev-tools, MySQL-jdbc-driver, Project Lombok, SpringDoc-api

## Data Flow
- Project implements an MVC architecture alongside a data-access directory to interface with the database.
- Control is first passed onto the endpoint handler in the controllers.
- The calls are delegated to the service layer wherein the business logic of the CRUD application exists.
- The DAO interfaces further extend the standard JPA-repositories to save and retrieve objects from the database.
- When a user signs up, his information is verified and persisted in the database.
- When a user signs in, he is assigned a unique token which must be passed to access the API.

- Source code is available at: [GITHUB](https://github.com/Pankaj-dev98/restaurant-management-service-geekster)

- Database design: Project uses a local relational MySql database with all required fields and constraints.

### Relationships
- A signed-in user is able to place multiple new orders(OneToMany)
- An order can be associated with a food item and food items can be part of many orders.

## Project Summary
Application is a well tested CRUD application for a restaurant management system.
All required functionalities have been implemented. Fields have been validated thoroughly and errors and exceptions are not ignored.
All dates are in yyyy-MM-dd format and time types are in HH:mm:ss format. 


