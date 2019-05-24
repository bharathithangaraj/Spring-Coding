Projection in Spring Jpa:
* Required plug-in is "spring-boot-starter-data-rest".
* Uses: when we want to restrict what is visible to clients, we need to use projections.
* Projections are used in order to query only a subset of the attributes of an entity or group of entities you're querying with Criteria. You can also use Projections to specify distinct clauses and aggregate functions like max, sum and so on. It's like referring to which data you're fetching. Like modifying the select clause in an SQL query.
* When a projection is used then the normal target entity will be loaded but dynamically projected

* For Example: we have a Course entity with Id, Name, duration with all its accessor methods (I,e- getters and setters), but suppose we want to show only courseName and restrict the getters of Id and duration. In this case we can project only courseName field by providing the Projection of Course class in CustomCourse interface.
@Projection(name = "customCourse", types = Course.class)
public interface CustomCourse {
	String getCourseName();
}

* The source code can be found on GitLab "jpa/ProjectionSpringDataRest".
