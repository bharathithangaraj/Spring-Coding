Executing Stored Procedure using Spring Boot:
* We can execute a SQL stored procedure from our application.
* 1st we need to have a stored procedure along with the table.
* For example: we have student table and a stored procedure "get_all_students".
* We can call a stored procedure using @NamedStoredProcedureQueries annotation as below:
* @NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getAllStudents", procedureName = "get_all_students",
    resultClasses = Student.class)})

* The source code can be found on GitLab "jpa/ExecutingStoredProcedures".
