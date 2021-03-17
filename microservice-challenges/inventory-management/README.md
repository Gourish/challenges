# Inventory Management

## Add Installation instructions here
 Install docker 
 run cassandra image on docker 
 run following commands
 docker run -p 9042:9042 --rm --name cassandra -d cassandra:latest
 
 docker exec -it cassandra bash
 
 cqlsh
 
 create keyspace inventory WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
 
 use inventory;
 
 create table product( id UUID, name text,category text,description text, quantity int, price int,primary key(id,name));
 
 To run the application run the following commands
 ./gradlew build
 
 go to build folder 
 cd build/libs
 
 run the jar 
 java -jar inventory-management-0.0.1-SNAPSHOT.jar
 
 The application exposes 7 APIs to perform CRUD operation and also search the prodcuts based on various parameters 
 
 1) This API lets user to add product to the db
 POST :  http://localhost:8080/addProduct 
 sample request body 
 {
           "name":"OPPO",
           "category":"Electronic gadget",
           "description":"Mobile phone for talking",
           "quantity":200,
           "price": 60000
 }
 
 sample response body
 {
     "id": "4a118775-0bd3-4174-84e7-e54e09e15e53",
     "name": "OPPO",
     "category": "Electronic gadget",
     "description": "Mobile phone for talking",
     "quantity": 200,
     "price": 60000
 }
 
 2) This API lets user to list all the products 
 GET : http://localhost:8080/productList
 
 sample response 
 [
     {
         "id": "4a118775-0bd3-4174-84e7-e54e09e15e53",
         "name": "OPPO",
         "category": "Electronic gadget",
         "description": "Mobile phone for talking",
         "quantity": 200,
         "price": 60000
     }
 ]
 
 3) This API lets user to get product based on ID
 GET : http://localhost:8080/productsListById/4a118775-0bd3-4174-84e7-e54e09e15e53
 
 sample response 
 {
     "id": "4a118775-0bd3-4174-84e7-e54e09e15e53",
     "name": "OPPO",
     "category": "Electronic gadget",
     "description": "Mobile phone for talking",
     "quantity": 200,
     "price": 60000
 }
 
 4) This API lets user to get product based on name 
 GET : http://localhost:8080/productsListByName/OPPO
 
 sample response 
 {
      "id": "4a118775-0bd3-4174-84e7-e54e09e15e53",
      "name": "OPPO",
      "category": "Electronic gadget",
      "description": "Mobile phone for talking",
      "quantity": 200,
      "price": 60000
  }
 
 5) This API lets user to get product based on category 
  
  GET: http://localhost:8080/productsListByName/OPPO
 
 sample response 
 {
     "id": "4a118775-0bd3-4174-84e7-e54e09e15e53",
     "name": "OPPO",
     "category": "Electronic gadget",
     "description": "Mobile phone for talking",
     "quantity": 200,
     "price": 60000
 }
 
 6) This API lets user to update the product 
 PUT : http://localhost:8080/productsListById/4a118775-0bd3-4174-84e7-e54e09e15e53
 sample request
 {
    "name": "OPPO",
    "category": "Electronic gadget",
    "description": "Mobile phone for talking",
    "quantity": 1000,
    "price": 60000
 }
 
 sample response
 {
    "name": "OPPO",
    "category": "Electronic gadget",
    "description": "Mobile phone for talking",
    "quantity": 1000,
    "price": 60000
 }
 
 7) This API lets user to delete the product
 DELETE : http://localhost:8080/deleteProduct/4a118775-0bd3-4174-84e7-e54e09e15e53
 

# Service Requirements
This service accomplishes the following 
* Product Management
  - Product CRUD
  - Product Search
* Inventory Levels
  - Inventory CRUD
Candidate may include their assumptions and choice of additional requirements in this section.
# Challenge - 1 Cassandra Database CRUD

## Goal

Configure a Cassandra database and implement a basic inventory CRUD service using **spring-data-cassandra**.

## Evaluation Criteria
This is a level 1 challenge. You will be evaluated on 
- [ ] Usage of common design patterns
- [ ] spring data concepts proficiency
- [ ] sprint boot concepts proficiency
- [ ] Ability to translate requirements into readable, reusable modules

# Challenge - 2 In addition to Challenge 1 Add test coverage
Add JUnit to the application and use a mocking framework of your choice to provide full test coverage for the implemented apis.

## Evaluation Criteria
This is a Level 2 challenge. You will be evaluated on 
- [ ] Test Driven Design proficiency 
- [ ] Mocking Framework mastery

# Challenge - 3 Add integration test coverage
Use CassandraUnit and an integration test framework of your choice to provide full integration test coverage for your apis
This is a level 3 challenge. You will be evaluated on
 - [ ]  Integration Test Proficiency
 - [ ]  Test Framework Mastery
 - [ ]  Test Configuration Mastery

# Challenge - 4 Add Swagger
Create api-first swagger compliant apis for inventory management

## Evaluation Criteria
This is a Level 3 Challenge. You will be evaluated on 
- [ ] Mastery of the spring boot ecosystem
- [ ] Mastery of api-first REST implementation

# Challenge - 4 Convert to Spring Cloud Function deployable to AWS
All controllers must be implemented as spring cloud functions

## Evaluation Criteria
This is a Level 3 Challenge. You will be evaluated on 
- [ ] Mastery of the spring cloud ecosystem
- [ ] Mastery of FaaS concepts
