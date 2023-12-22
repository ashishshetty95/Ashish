package Parameters;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Parameter {
	@Test
	public void pathParameterTest() {
		baseURI="http://rmgtestingserver";
		port=8084;
		given().pathParam("projectId", "TY_PROJ_032")
		
		.when().get("/projects/{projectId}")
		.then().log().all();
	}
	
	@Test
	public void formParameterTest() {
		//baseURI="http://rmgtestingserver";
		//port=8084;
		given().formParam("createdBy", "Hemanth")
		.formParam("projectName", "HKart")
		.formParam("status", "active")
		.formParam("teamSize", 8).post("http://rmgtestingserver:8084/addProject").then().log().all();
	}
	
}
