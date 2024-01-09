package Mock;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Authentication {
	@Test
	public void basicAuth() {
		JSONObject obj=new JSONObject();
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.body(obj).contentType(ContentType.JSON).then()
		.log().all();
	}
	
	
}
