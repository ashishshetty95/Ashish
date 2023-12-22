package ReqreswithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class updateUser {
	@Test
	public void put() {
		JSONObject obj=new JSONObject();
		obj.put("name", "abc");
		obj.put("job", "asd");
		given().body(obj).contentType(ContentType.JSON)
		.when().put("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(200).log().all();
	}
}
