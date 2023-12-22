package DiffWaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDwithoutBDD {
	@Test
	public void create() {
		JSONObject obj=new JSONObject();
		obj.put("id", 1);
		obj.put("username", "AshishShetty@1");
		obj.put("firstName", "Ashish");
		obj.put("lastName", "Shetty");
		obj.put("email", "abc@gmail.com");
		obj.put( "password","abc");
		obj.put("phone", "9876543210");
		obj.put("userStatus", 1);
		RequestSpecification giv = RestAssured.given();
		Response response = giv.body(obj).contentType(ContentType.JSON).post("https://petstore.swagger.io/v2/user");
		System.out.println(response.prettyPeek());
	}
	
	@Test
	public void get() {
		Response response = RestAssured.get("https://petstore.swagger.io/v2/user/AshishShetty@1");
		response.then().log().all();
	}
	
	@Test
	public void delete() {
		RestAssured.delete("https://petstore.swagger.io/v2/user/AshishShetty@1").then().log().all();
	}
}
