package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteProject {
	@Test
	public void delete() {
		Response response = RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_1120");
		response.then().log().all();
		
	}
}
