package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2 {
	@Test
	public void oauth() {
		Response response = given()
		.formParam("client_id", "plmokn")
		.formParam("client_secret", "8d6593b9bd070b33cefacec004578faf")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://qwerty.com")
		.formParam("code", "authorization_code")
		 .post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		System.out.println(token);
		
		given().auth().oauth2(token)
		.pathParam("USER_ID", 4801)
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-count").then().log().all();
	}
}
