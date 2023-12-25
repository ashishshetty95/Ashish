package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

public class WaysToPostRequest {
	// 1. USING JSON OBJECT
	@Test
	public void jsonObject() {
		JSONObject obj=new JSONObject();
		obj.put("name", "jsonObject");
		obj.put("job", "post");
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();		
	}
	
	// 2. USING HASHMAP
	@Test
	public void hashMap() {
		HashMap map = new HashMap();
		map.put("name", "HashMap");
		map.put("job", "post");
		given()
		.body(map)
		.contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(201)
		.log().all();
	}
	
	//3. USING JSONFILE
	@Test
	public void jsonFile() {
		File file=new File("./reqres.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.post("https://reqres.in/api/users")
		.then().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
	
	
	//4. USING POJOCLASS
	@Test
	public void pojoTest() {
		POJOClass pojo = new POJOClass("pojo", "post");
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201)
		.log().all();
	}
}
