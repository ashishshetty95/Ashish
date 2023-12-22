package CRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	@Test
	public void createProject() {
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Ashish Shetty");
		jObj.put("projectName", "AmazonKart");
		jObj.put("status", "Active");
		jObj.put("teamSize", 5);
		
		RequestSpecification giv = RestAssured.given();
		giv.body(jObj);
		giv.contentType(ContentType.JSON);
		Response response = giv.post("http://rmgtestingserver:8084/addProject");
		System.out.println(response.prettyPeek());
	}
}
	