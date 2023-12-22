package ReqreswithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createUser {
	@Test
	public void create() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Ashish");
		obj.put("job", "Trainee");
		RequestSpecification ra = RestAssured.given();
		ra.body(obj);
		ra.contentType(ContentType.JSON);
		Response response = ra.post("https://reqres.in/api/users");
		System.out.println(response.prettyPeek());
	}
}
