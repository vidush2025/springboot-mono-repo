# 3 Layered Architecture framework

The client requests goes through to the server and all buisness logic including communication with database can be wrapped up into 3 layers:

1. Presentation Layer -> also called "Controller". Client first sends to request to this layer directly. Client may send request including data like form-data, and fetch calls. It forwards the information to the Service layer using DTO(Data Transfer object).

2. Service Layer -> It uses the DTO to run the main buisness logic for the backend. It analyses, authenticates, verifies  the DTO, and also communicates with the DB using "Entity" or "Model.

3. Persistence Layer -> also called Data-access layer. This Layer communicates directly with the database, and sends, or fetcehs data from the db. It again returns an "Entity" of the db data to the service layer, which returns a new(or updated) DTO to the presentation layer. 

4. Finally the Presentation layer converts the DTO into JSON and sends back to the frontend/client.

-- This method helps in encapsulation and isolation  of data (and the database).

# Lombok annotations
- @Data: helps to create contructors, getters, setters etc and ignore all boiler plate code for all controllers
- @AllArgsConstructor: simply creates a constructur with ALL of the arguments in a DTO/java class.

# @RestController annotation

- creates a bean and helps in mapping of a controller.

- @GetMapping is just like a get request on the desired server port which will return a JSON response to the client. It helps to determine the routes, ex: "/student" 

# @RequiredArgsConstructor
- creates a constructor automatically for all "private final -" variables


# BASIC FLOW OF CLIENT <-> DB 

- The client sends a request to persistent layer using a RestAPI(get, post etc.),which is handled by a controller, here StudentController.
- The controller is like a route file and NOT like a javascript controller where we have all business logic in the controller. The controller ONLY MAPS the client request to the correct service.
- When a service interface is called, the service class performs all business logic and functions, and connects with the repository (database) for data communication.
- This helps in maintaining a block between client and database.
- Finally the repository directly handles database quries, and sends data to the service, which sends DTO to the controller.
- The controller then sends back the data to the client as a json response.

CLIENT --RestAPI--> CONTROLLER --Mapping & DTO--> SERVICE --Entity--> REPOSITORY --Query--> DATABASE --Query Results--> REPOSITORY --Entity--> SERVICE --Result DTO--> CONTROLLER --Response JSON--> CLIENT


# @PathVariable

- Used to send dynamic parameter requests in api calls, for example, sending "id" for a getStudentById api call
- Can be used to fetch only relevant and filtered data from the database

# ModelMapper

- This maps one Database schema/entity to another(ex: Student -> StudentDto)
- It uses the field names in the entity definition to map the elements, thats why the two entities must have similar/same field names in the class definition.
- It also requires the "@NoArgsConstructor" annotation to map the entities properly, otherwise throws error
- ModelMapper is a very reusable and efficient Springboot library/dependency, thus can be placed in the "config" folder so that it may be accessed by all the service classes when needed.
