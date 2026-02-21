# SPRING DATA JPA
JPA stands for Jakarta Persistence Layer for Java Springboot which helps us to communicate qwith the backend.
It is a Springboot library, and a dependency through which we can easily run queries and communicate with the database whenevery required.
It helps to CRUD data in different tables in a database configured for our application.

# Testing on Springboot
We can easily run tests for code and also perform DB queries for testing using the "@SpringbootTest" annotation. It represents that the mentioned class is a test class. To run any test function, we just need to add the "@Test" annotation above its definition. A test function runs directly in the code as a script and does not need the to be called using entities/DTOs etc. 

NOTE: The return typeof any test function must be void because the test functions just read data and cannot return anything specifically. 


# @ToString annotation
This annotation helps to easily print or return our Entity data in string format. By default, for a statement like:

    List<Patient> patients = patientRepository.findAll();

The patients will have data a link and a hexcode for the entities that the backend returns. We mostly don't want a returned data like this. The @ToString annotation above any Entity helps SpringBoot to understand that we need data in a mapped form for easier reading, updating and understanding.

If we have the annotation above the Patient schema definition, will return data like:
    
    List of Patients:[Patient(id=1, name=Vidush1, sex=male, email=vidush1@gmail.com)]

We can exclude any field to NOT be returned, we can explicitly put the "@ToString.Exclude" annotation, and that field will NOT be returned in the above response. 


# Entity Manager

EntityManager is an interface that internally performs all JPA related functions and helps in the Hibernate Entity Life Cycle. All repository related functions like 
find, get, save, load, are internally performed by the EntityManager in the SimpleJpaRepository.class.

# Hibernate Entity Life Cycle

The hibernate-entity life cycle is a combined life cycle of how data is loaded, or written on DB using our Springboot application. 

    1. Transient State
Initially when an Entity creates an object like:
Patient pat = new Patient();
    
Here the "pat" will NOT be stored in the db initially (until we run a function like save(), persist(), update()). This phase of an Entity Object being created and stored in Heap memory before being saved to Database is called "TRANSIENT" state.

For some reason, if the save() function is not called, the 'pat' object will simply be thrown into the Java Garbage Collector.

    2. Persistent State
This is the layer which communicates with the database. All get/load, save/persist etc. functions result in the data to enter the Persistent State. This means the data is freshly fetched from DB or just updated. So in Persistent State, data is up-to-date with the DB.

This also acts a caching Layer, and if the data is already present in the Persistent State, the DB query is skipped and current data is returned.

In Persistence layer, an object is updated, but not 'saved', then when the program is stopped, Dirty checking happens that identifies the modification of data in this layer. The save function is automatically called and thus data is automatically updated if it is present in this state.

    3. Removed State
When a data object in the persistent layer is operated with delete/removed kind of functions, the data object enters the removed state. This means its deleted from the DB and CANNOT be retrieved anymore. When the program closes, the objects in Removed state are just thrown into the Garbage Collector.

    4. Detached State
When an object is operated upon with functions like detach(), close(), clear(), the data enters detached state. This state means that our data is on the way to be removed BUT it is still not deleted from the database. 

To retrieve an object present from Detached State, we operate functions like merge(), save(), lock(). These make sure that the data is retrieved back the Persistent State.

Any Object present in Detached State, after the execution of the program, is simply thrown into the Garbage Collector.

# @Transactional Annotation
This annotation helps to maintain consistency in the DB.
Whenever a query is made from a method, the Transactional annotation helps to securely read/store data in DB. the query is executed as a transaction, and all validations are checked. IF any validation fails, the query is not declined and an error is returned. The final update/read is only done after all the validations are checked session is marked successful by the transactional annotation.

It also helps in fetching the cached data, if 3-4 queries are written together for the same entity/object, this annotation makes sure ONLY the first query is ran and all others simply fetch data from the cached Persistent state. It also makes the DB queries much faster.

# @Table Annotation
This annotation helps us to change the configuration of the table created for our Entity. We can perform all sorts of operations ranging from changing the name of the table, to adding unique constraints (fiels which must be unique among all entities), and adding indices on required fields (index-es).
Similarly, we have @Coloumn annotation which helps to define characters of a single column in a table. We can enforce rules like  "unique: true", "editable: false" etc., to make the column verify and validate the data before any row is updated/created.


    
