# forEISTI

A simplistic forum meant for discussions of many different topics in EISTI/CY Tech, developed in JEE with Spring Boot

## Dependencies

- Java 17
- MySQL

## Deployment / Execution

Edit the `src/main/resources/application.properties` file to have your MySQL credentials and optionally the database name you desire. (Make sure said database exists beforehand.)

To make running the server easier, a script is provided and can simply be run with `./run`.

### Maven

Because of the dependency on Java 17, Maven version 3.8.6 needs to be used.

- If you have Maven 3.8.6 installed globally on your system, that will be used.

- If not, a version of Maven 3.8.6 will be downloaded and later used by the `run` script.

Both cases are covered by the `run` script.

### Other things to note

The administrator user's credentials are `admin`:`admin`

## Added features since December 07, 2022

- Cross-site scripting (XSS) prevention

- ManyToMany associations in the database for categories, with board manager functionalities to match

- Startup procedure made easier
