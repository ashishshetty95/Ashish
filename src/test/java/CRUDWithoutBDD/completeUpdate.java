package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class completeUpdate {
	@Test
	public void completeModify() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Ashish shetty");
		obj.put("projectName", "Fliokart");
		obj.put("status", "Completed");
		obj.put("teamSize", 15);
		RequestSpecification rs = RestAssured.given();
		rs.body(obj);
		rs.contentType(ContentType.JSON);
		Response response = rs.put("http://rmgtestingserver:8084/projects/TY_PROJ_1120");
		
		System.out.println(response.prettyPeek());
	
	}
}
