Dynamic finders as fluent API - Spring JPA queries:
* Spring Data is pretty convenient and speeds up development, avoiding boilerplate code.
* However, there are cases where annotation queries are not enough for the custom functionality.
* Therefore, Spring Data allows us to add custom methods to a Spring Data Repository.

* For Example- Suppose that we want to add some custom SQL functionality, for example querying with a LIKE statement. This is not fully supported even in JDBC since we have to pass our variable concatenated with the character ‘%’.

* So what we need is a native JPA query like this one:
	Query query = entityManager.createNativeQuery("SELECT st.* FROM wavelabs.student as st 		WHERE st.name LIKE ?", Employee.class);
	query.setParameter(1, firstName + "%");

* In order to add this functionality to our Spring Data Repository, we have to add an interface. It is mandatory for our interface to follow the naming convention of ${Original Repository name}Custom or Custom{Original Repository name}. 
* Therefore, the interface describing our custom functionality should be: 

	public interface CustomStudentRepository {
		List<Employee> getNamesLike(String firstName);
	}

* And the implementation should be:
	public class CustomStudentRepositoryImpl implements CustomStudentRepository { 
		//add unimplemented methods	
	}

* And we should change our original Spring Data repository in order to inherit the custom functionality.
	@Repository
	public interface StudentRepository extends JpaRepository<Employee,Long>, 			CustomStudentRepository {}

* Now let's call this custom method in any of the Dao's or service class.
	return studentRepository.getNamesLike(firstName);

* The source code can be found on GitLab "jpa/DynamicFinderAsFluentAPI".
