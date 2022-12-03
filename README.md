# forEISTI

A simplistic forum meant for discussions of many different topics in EISTI/CY Tech, developed in JEE with Spring Boot

## Dependencies

- Java 17
- MySQL

## Deployment / Execution

### Maven

- If you have Maven 3.8.6 installed, you can run the usual `mvn spring-boot:run` command to start the server.

- If not, a version of Maven 3.8.6 is provided locally and the server can be started simply with the provided `./run` script.

### Initial setup

1. Edit the `src/main/resources/application.properties` file to have your MySQL credentials and optionally the database name (make sure the database exists!)
2. Run the server once so JPA can create the database tables
3. Run the `src/main/resources/data.sql` script to insert initial data in the database
4. Run the server

### Other things to note

The administrator user's credentials are `admin`:`admin`
