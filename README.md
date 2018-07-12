# CraftDemo


# Design 

## Use Case Model
From the business case and high level requirements I identified several use cases and created a use case diagram.
![Use Case Diagram](https://github.com/gitizenme/CraftDemo/blob/master/Architecture/UseCaseDiagram.png "Use Case Diagram")

### Actor
* Employee: An employee is a user who is accesses the service to read and post messages for other users to read.

### Uses Cases
1 User Login
  * As a user I would like to login to the application in order to interact with messages.
1 User Logout
  * As a user I would like to logout from the application in order to keep my information secure.
1 View Messages
  * As a user I would like to view the 100 most recent messages.
1 Post Message
  * As I user I would like to post messages to my followers. 

## Domain Model
As part of the analysis of the use cases I developed the following domain model diagram.
![Domain Model](https://github.com/gitizenme/CraftDemo/blob/master/Architecture/DomainModel.png "Domain Model")

The system breaks down into a typical n-tier layered architecture with the following packages and components:
* Controllers
This package contains the controller logic and is the primary interface point of the REST API. In this package are the following components
  * Users - Contains the API for authentication and authorization
  * Message - Contains the API for creating, editing and deleting individual messages for a user
  * Feed - Contains the API for querying the message feed for a user
* Services
This package contains the services that are needed to realize the API
  * AuthenticateCommand
  * LogoutCommand
  * PostMessageCommand
  * GetFeedCommand
* Models
This package contains the data models that are used to persist information
  * Users - A repository that contains a collection of Users and related query methods
  * User - An object that contains the properties for an individual user
  * Messages - A repository that contains a collection of Messages and relagted query methods
  * Message - An object that contains the properties for an indivudal messages
Additionally specified are the relationships between the Users and Messages with cardinality.
* Tests
A set of unit, functional and integration tests for the system.

## Deployment 
For deployment I selectd the Spring Boot framework and related compontents to support the following capabilties:
* REST API (Spring)
* DI/IoC (Spring)
* Persistence (JPA)
* Security (Spring LDAP)
* Testing (JUnit + Spring Runner)

# Implementation 

## Development Environment
* Java 8
* IntelliJ w/Spring Plugins
* Postman

## Development Notes
* Built out a `ping` API first to verify aliveness and to report service meta data (i.e. version number).
* Built out the `feed` API based on current user principal and render to JSON via REST call. 
* All services are secured using form based login with local LDAP store.
* Test data generated using `@PostConsturct` in the `ServerInit` class in order to verify implementation. Should be removed in production.
* Attempted unit testing at the API level. However, the form based authentication prevent productivity in this aspect of the project. 

## Next Steps
* Move away from form based auth and implement JWT for caller authentication. 
* Verify implementation of `feed` matches the requirements.
* Continue with implementation of `post` new messages for current user.

# Business Case
As part of enhancing our internal services which are available to our employees, we would like to build a Twitter like solution for our employees, where employees can tweet and have followers. 

## High Level Requirements:
* We have 10K employees.
* Employees can follow their colleagues, post (or tweet) messages to their followers.
* Use corporate LDAP for user Management.
* On an average, every employee will send approximately 10 messages a day to their followers.
* On the home page we need to show 100 most recent tweets. Optionally you can support pagination.
* You are welcome to assume unspecified requirements to make it better for the customers.
* Come prepared with High level Architecture and Design. 
* You are expected to explain the rationale for your choice of technologies and architectural patterns.
* This is an open-ended exercise. The goal is to demonstrate how well you design a system with limited requirements. 

## Programming Problem:
In the above exercise, please build a RESTful service.

* /feed : To list 100 recent tweets for the logged in user.
* In memory database is sufficient. Optionally, you are welcome to use a persistent data store of your choice.
* You do not need to provide any UI. You can show the API using any tool like swagger or even use a REST client like POSTMAN. Unit tests also works
* LDAP is mentioned to give you a sense of the problem. We are not expecting you to integrate LDAP with the solution. Feel free to stub it out.
* You are encouraged but not required to take advantage of a service code-generation framework of your choice when performing this exercise.
