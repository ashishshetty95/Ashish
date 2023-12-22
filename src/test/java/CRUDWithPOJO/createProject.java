package CRUDWithPOJO;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class createProject {
	@Test
	public void create() {
		createProjectPOJO cpp = new createProjectPOJO("Ashish", "POJOTest", "started", 5);
		Response response = RestAssured.given().body(cpp).contentType(ContentType.JSON).post("http://rmgtestingserver:8084/addProject");
		response.then().assertThat().statusCode(201).log().all();
	}
}
