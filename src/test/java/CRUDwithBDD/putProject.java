package CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class putProject {
	@Test
	public void put() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "VK");
		obj.put("projectName", "RCB");
		obj.put("status", "active");
		obj.put("teamSize", 11);
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.put("http://rmgtestingserver:8084/projects/TY_PROJ_1226")
		.then()
		.assertThat().statusCode(200).log().all();
	}
}
