package ReqreswithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class createUser {
	@Test
	public void create() {
		JSONObject obj=new JSONObject();
		obj.put("name", "abc");
		obj.put("job", "asd");
		given().body(obj).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).log().all();
	}
}
