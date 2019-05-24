Criteria Queries - Spring Boot Data:
* Spring Data Repositories allow writing fewer queries, it is even possible to write just method signatures and Spring will make queries for them by itself.

* Spring Data JPA provides many ways to deal with entities including query methods and custom JPQL queries. However, sometimes we need a more programmatic approach: for example Criteria API or QueryDSL.

* Criteria API is a type-safe API for composing JPQL queries.

* Criteria API offers a programmatic way to create typed queries, which helps us avoid syntax errors. Even more, when we use it with Metamodel API, it makes compile-time-checks whether we used the correct field names and types.

* However, it has its downsides: we have to write verbose logic bloated with boilerplate code.

* we've 3 ways to use criteria queries in our Spring application:
1. Extending a @Repository interface: to seamless integration with automatic queries
2. Creating a DAO class:  the most straightforward and most flexible way.
3. Using predicates in Specification instances: to make the simple cases cleaner and less verbose.


* Extending a @Repository interface:
1. if we want a @Repository interface to have a method with a custom implementation, we can use composable repositories.
2. To create our own repository queries using Criteria API, we must create an interface, let’s call it "IStudentRepositoryCustom" and a class implementing this interface "StudentRepositoryImpl".
3. Note: When the interface is being implemented, the name of the class should coincide with the name of the heir repository JpaRepository, with the addition of “Impl” (this is mandatory).
4. The "IStudentRepositoryCustom" interface will have one method signature with arguments which the data will be filtered by (name, and passportNumber of the Student).
5. When we declare "StudentRepository" as a dependency, Spring finds "StudentRepositoryImpl" and uses it when we invoke the custom methods.
6. for example: when we want to find the Student by name and passportNumber which could have both prefix and suffix in his name and passportNumber. Here we need to apply a predicate for each constraint like for name and for passportNumber respectively.
7. Note: if we have many predicates and want to make them optional, then this approach will makes the code hard to maintain.
8. The source code can be found on GitLab "jpa/JpaCriteriaQueries".

* creating a DAO class: 
1. First, we get a CriteriaBuilder reference, which we can use to create different parts of the query
2. Using the CriteriaBuilder, we create a CriteriaQuery<Student>, which describes what we want to do in the query. Also, it declares the type of a row in the result. 
3. With CriteriaQuery<Student> we declare the starting point of the query (Student entity), and we store it in the book variable for later use
4. Next, with CriteriaBuilder we create predicates against our Book entity. Note, that these predicates don’t have any effect yet
5. We apply both predicates to our CriteriaQuery. CriteriaQuery.where(Predicate…) combines its arguments in a logical and. This is the point when we tie these predicates to the query
6. After that, we create a TypedQuery<Student> instance from our CriteriaQuery
    Finally, we return all matching Book entities.

