package Mock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CRUDWithBDD {
	@Test
	public void create() {
		JSONObject obj=new JSONObject();
		obj.put("name", "ashish");
		obj.put("job", "trainee");
		given()
		.body(obj).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
	}
}
