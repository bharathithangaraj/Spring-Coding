Finder queries using JPQL(SQL and HQL) - Spring JPA queries:
* Spring Data is pretty convenient and speeds up development, avoiding boilerplate code.
* Spring Data supports annotation based queries for the custom functionality.
	@Query or @NamedQuery
* Therefore, Spring Data allows us to add JPQL (I,e- SQL/HQL) using @Query Annotation.

* For Example- Suppose that we want to add some custom SQL functionality, for example querying with a LIKE statement. This is not fully supported even in JDBC since we have to pass our variable concatenated with the character ‘%’.

* So what we need is a native JPA query string like this one:
	@Query("select st from Student as st where st.name like %?1")

* In order to add this functionality to our Spring Data Repository, we have to add this annotation to our original Spring Data repository interface.

* Therefore, the interface describing our custom functionality will be: 
	@Repository
	public interface StudentRepository extends JpaRepository<Employee,Long> {
		@Query("select st from Student as st where st.name like %?1") 
		List<Student> findByNameEndsWith(String chars);	
	}

* Now let's call this custom method in any of the Dao's or service class.
	return studentRepository.findByNameEndsWith(lastname);

* The source code can be found on GitLab "jpa/FinderQueriesUsingJPQL".
