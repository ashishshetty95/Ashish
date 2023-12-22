package Authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearerToken() {
		JSONObject obj=new JSONObject();
		obj.put("name", "bearer");
		given()
		.auth().oauth2("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")
		.body(obj)
		.contentType(ContentType.JSON)
		.post("https://api.github.com/user/repos").then().statusCode(201).log().all();
	}
	
	@Test
	public void getRepo() {
		given()
		.get("https://api.github.com/repos/ashishshetty95/bearer")
		.then().statusCode(200).log().all();
	}
}
