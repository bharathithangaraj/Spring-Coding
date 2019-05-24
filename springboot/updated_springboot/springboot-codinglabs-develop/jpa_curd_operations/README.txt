This is a SpringBoot_RestAPI project to perform CRUD operations using JPARepository 

 ->Spring Data JPA, part of the larger Spring Data family,
   makes it easy to easily implement JPA based repositories.
   This module deals with enhanced support for JPA based data access layers.
   It makes it easier to build Spring-powered applications that use data access technologies.
   
->Connection of Database and JPA to our application
   provide the following property of database connection and JPA in application.properties file
     -spring.datasource.url=jdbc:mysql://localhost:3306/mydb?useSSL=false
      spring.datasource.username=root
      spring.datasource.password=root
      spring.datasource.driver-class=com.mysql.jdbc.Driver
      spring.jpa.hibernate.ddl-auto=update
   
We have a predefined interface JPARepository in (PACKAGE)org.springframework.data.jpa.repository.JpaRepository;
It have some predefined methods in it - findAll(), getOne(), save(), delete() 
    which makes our task easier to perform operations on database using our application.

-SpringRestApplication.java
   It is class which we will get by the Creating the spring starter project
   
-In our application we are not going to implement all the methods of the JPARepository
    So creating an interface StudentRepository and inheriting the JPARepository Interface to use the required 
    methods from JPARepo in the StudentService   
    
-StudentService.java
  It is a class where we write methods for performing the particular operation and using 
  the JPARepo interface methods and these methods are used by StudenCcontroller
   
-StudentController.java
  It is the class where we have defined @RestController annotation which automatically search for the
  RequestMapping and executes them according to the provided mapping type or method type(GET,POST,PUT,DELETE) 
   