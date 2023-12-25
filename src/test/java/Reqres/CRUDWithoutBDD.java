package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class CRUDWithoutBDD {
	
	@Test
	public void createUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Test");
		obj.put("job", "check");
		RequestSpecification give = RestAssured.given();
		give.body(obj);
		give.contentType(ContentType.JSON);
		Response resp = give.when().post("https://reqres.in/api/users");
		System.out.println(resp.prettyPrint());
		int sCode = resp.getStatusCode();
		Assert.assertEquals(201, sCode);
		//resp.then().log().all();
	}
	
	@Test
	public void getUser() {
		Response resp = RestAssured.when().get("https://reqres.in/api/users/2");
		int sCode = resp.getStatusCode();
		Assert.assertEquals(200, sCode);
		resp.then().statusCode(200);
		resp.then().log().all();
	}
	
	@Test
	public void putUser() {
		JSONObject obj=new JSONObject();
		obj.put("name", "Test1");
		obj.put("job", "check1");
		RequestSpecification give = RestAssured.given();
		give.body(obj).contentType(ContentType.JSON);
		Response resp=give.post("https://reqres.in/api/users/2");
		resp.then().statusCode(200);
		resp.then().log().all();
	}
	
	@Test
	public void deleteUser() {
		Response resp = RestAssured.when().delete("https://reqres.in/api/users/2");
		resp.then().statusCode(204);
		System.out.println(resp.getStatusCode());
		resp.then().log().all();
	}
}
