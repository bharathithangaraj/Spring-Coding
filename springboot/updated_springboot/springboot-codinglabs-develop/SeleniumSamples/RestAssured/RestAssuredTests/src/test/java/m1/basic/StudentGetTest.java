package m1.basic;

import static io.restassured.RestAssured.*;

import org.junit.Test;

import io.restassured.response.Response;

import com.student.base.TestBase;


public class StudentGetTest extends TestBase{

	/**
	 * given()
	 * set cookies,add auth,adding parameters,setting header info
	 * .when()
	 * GET,POST,PUT,DELETE..etc
	 * .then()
	 *  Validate status code,extract response, extract headers,cookies,extract the response body
	 */


	@Test
	public void getAllStudentInformation(){
		System.out.println("*** Started .. getAllStudentInformation");
		Response response=
        given()
		.when()
		    .get("/list");
		
		System.out.println(response.body().prettyPrint());
	}

	@Test
	public void validateStatusCode(){
		System.out.println("*** Started .. validateStatusCode");
		//Validate the status code

		given()
		.when()
		.get("/list")
		.then()
		.statusCode(200);
		
	}
	
	@Test
	public void getStudentInfo1(){
		System.out.println("*** Started .. getStudentInfo1");
		Response response=
		given()
		.when()
			.get("/12");
		
		response.body().prettyPrint();
	}

	@Test
	public void getStudentInfo2(){
		System.out.println("*** Started .. getStudentInfo2");

		given()
		.when()
			.get("/1")
		.then()
				.log().all()
			.statusCode(200);
	}
	
	@Test
	public void getStudentsFromFA(){
		System.out.println("*** Started .. getStudentsFromFA");
		Response response=	given()
		.when()
		.get("/list?programme=Financial Analysis&limit=2");
		
		System.out.println(response.prettyPeek());
	}

	@Test
	public void getStudentsFromFA_withParam(){
		System.out.println("*** Started .. getStudentsFromFA_withParam");

		Response response= given()
		.param("programme", "Financial Analysis")
		.param("limit",2)
		.when()
		.get("/list");
	
		System.out.println(response.prettyPeek());
	}

}
