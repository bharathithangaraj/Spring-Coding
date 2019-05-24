QueryHints - Spring JPQL:

* JPA and Hibernate support a set of hints which you can use to provide additional information to your persistence provider to influence the execution of a query. You can use them for lots of different things, like setting a timeout for your query, using an entity graph or defining the caching of a query result.

* Few JPA Hints are:
1. javax.persistence.lock.timeout (Long – milliseconds): This hint defines the timeout in milliseconds to acquire a pessitimistic lock.
2. javax.persistence.query.timeout (Long – milliseconds): The javax.persistence.query.timeout hint defines how long a query is allowed to run before it gets canceled. 
3. org.hibernate.flushMode (FlushMode – AUTO | ALWAYS | COMMIT | MANUAL): If you modify an entity, Hibernate keeps these changes in the first-level cache until it gets flushed.
4. org.hibernate.readOnly (boolean): If you will not apply any changes to the selected entities, you can set the org.hibernate.readOnly hint to true. This allows Hibernate to deactivate dirty checking for these entities and can provide a performance benefit.
5. org.hibernate.comment (String – custom comment): If you set the hibernate.use_sql_comments property in your persistence.xml file to true, Hibernate generates a comment for each query and writes it to the log file. 
6. org.hibernate.cacheable: If you want to use Hibernate’s query cache, you have to activate it in the persistence.xml file and enable it for a specific query by setting the org.hibernate.cacheable hint to true.
etc...


* For example: fetching entities in read-only mode is much more efficient than fetching read-write entities. Even if the entities are mutable, you can still fetch them in read-only mode, and benefit from reducing the memory footprint and speeding up the flushing process because the Read-only entities are skipped by the dirty checking mechanism.
* following way we can implement get an entity class in read-only mode:
	@NamedQuery(name = "Student.fetchByNameLength",
		query = "SELECT st FROM Student as st WHERE CHAR_LENGTH(st.name) =:length ",
		hints = { @QueryHint(name = "org.hibernate.readOnly", value = "true")})
* The source code can be found on GitLab "jpa/QueryHintsAnnotation".


