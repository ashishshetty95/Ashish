package CRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class createProject {
	@Test
	public void post() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Virat Kohli");
		obj.put("projectName", "RCB"+new Random().nextInt(200));
		obj.put("status", "Playing");
		obj.put("teamSize", 11);
		//Pre condition
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		//actions
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		
		//validation
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
