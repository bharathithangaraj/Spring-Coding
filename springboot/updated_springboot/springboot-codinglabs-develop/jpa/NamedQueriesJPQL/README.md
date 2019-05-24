Named queries - Spring JPQL:

* Spring Data is pretty convenient and speeds up development, avoiding boilerplate code.
* Spring Data supports annotation based queries for the custom functionality.
	@NamedQuery or @Query
* @NamedQuery annotation is a predefined query that we create and associate with a container-managed entity. @Query annotation is a similar annotation, which declares finder queries directly on repository methods. While @NamedQuery is used on domain classes, Spring Data JPA @Query annotation is used on Repository interface. This frees the domain classes from persistence specific information as a plus point.

* Therefore, Spring Data allows us to add JPQL (I,e- SQL/HQL) using @NamedQuery Annotation.

* For Example- Suppose that we want to add some custom SQL functionality to fetch student data by name length.

* So what we need is a native JPA query string like this one:
	@NamedQuery(name = "Student.fetchByNameLength",
	query = "SELECT st FROM Student as st WHERE CHAR_LENGTH(st.name) =:length ")

* In order to add this functionality to our Spring Data Repository, we have to add this annotation to our original Spring Data repository interface.

* Therefore, the interface describing our custom functionality will be: 
	@Repository
	public interface StudentRepository extends JpaRepository<Student,Long>, 			IStudentRepositoryCustom{
		List<Student> fetchByNameLength(@Param("length") Long length);
	}

* Now let's call this custom method in any of the Dao or service or test class.
	return studentRepository.fetchByNameLength(11l);

* The source code can be found on GitLab "jpa/NamedQueriesJPQL".
