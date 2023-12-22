package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRUDWithPOJO.createProjectPOJO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicAuth {
	
	
	@Test
	public void basic() {
		given()
		.auth()
		.basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://rmgtestingserver:8084/login")
		.then().statusCode(202)
		.log().all();
	}
	
	@Test
	public void digestive() {
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.get("http://rmgtestingserver:8084/login").then()
		.statusCode(202).log().all();
	}
	
	@Test
	public void preemptive() {
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.then().statusCode(202).log().all();
	}
}
