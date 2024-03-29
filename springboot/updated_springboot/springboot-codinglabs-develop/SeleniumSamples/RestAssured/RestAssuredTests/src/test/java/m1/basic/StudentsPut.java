package m1.basic;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import java.util.ArrayList;

import org.junit.Test;

import com.student.base.TestBase;
import com.student.model.Student;
public class StudentsPut extends TestBase{
	

	
	
	@Test
	public void updateStudent(){
		//Put the student ID here
		String studentId="50";
		
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("C#");
		
		Student student = new Student();
		student.setFirstName("Mark");
		student.setLastName("Taylor");
		student.setEmail("xyz@gmail.com");
		student.setProgramme("Computer Science");
		student.setCourses(courses);
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.body(student)
		.put("/"+studentId)
		.then()
		.statusCode(200);
		
	
	}

}
