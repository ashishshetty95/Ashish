package Reqres;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Authentication {
	@Test
	public void basicAuth() {
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when().get("http://rmgtestingserver:8084/login")
		.then().log().all();
	}
	
	@Test
	public void digestive() {
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.get("http://rmgtestingserver:8084/login")
		.then().log().all();
	}
	
	@Test
	public void preemptive() {
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.get("http://rmgtestingserver:8084/login")
		.then().log().all();
	}
	
	@Test
	public void bearerToken() {
		JSONObject obj=new JSONObject();
		obj.put("name", "bearertoken");
		given()
		.auth().oauth2("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")
		.body(obj).contentType(ContentType.JSON)
		.when().post("https://api.github.com/user/repos")
		.then().log().all();
		
	}
	
	@Test
	public void Oauth2(){
		Response resp=given()
		.formParam("client_id", "kokka")
		.formParam("client_secret", "559a21240dd489b27ad35d53ff6f9970")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://www.kokka.com")
		.formParam("code", "authorization_code")
		.post("http://coop.apps.symfonycasts.com/token");
		String token=resp.jsonPath().get("access_token");
		given()
		.auth().oauth2(token)
		.pathParam("id", 4806)
		.post("http://coop.apps.symfonycasts.com/api/{id}/barn-unlock")
		.then().log().all();
	}
}
