package Mock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class CRUDWithOutBDD {
	@Test
	public void create() {
		JSONObject obj=new JSONObject();
		obj.put("name", "ashish");
		obj.put("job", "trainee");
		RequestSpecification give = RestAssured.given();
		give.body(obj).contentType(ContentType.JSON);
		Response response = give.post("https://reqres.in/api/users");
		response.then().statusCode(201).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void get() {
		RequestSender when = RestAssured.when();
		when.get("https://reqres.in/api/users/2").then().statusCode(200).contentType(ContentType.JSON).log().all();
	}
}
