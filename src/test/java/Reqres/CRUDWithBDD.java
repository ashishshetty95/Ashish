package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

	import static io.restassured.RestAssured.*;

public class CRUDWithBDD {
	@Test
	public void createUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Test");
		obj.put("job", "check");
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}
	
	@Test
	public void getUser() {
		when()
		.get("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	@Test
	public void putUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Test");
		obj.put("job", "check");
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.put("https://reqres.in/api/users/2")
		.then().statusCode(200)
		.log().all();
	}
	
	@Test
	public void deleteUser() {
		when()
		.delete("https://reqres.in/api/users/2")
		.then().statusCode(204)
		.log().all();
	}
}
