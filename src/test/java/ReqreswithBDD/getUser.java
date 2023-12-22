package ReqreswithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getUser {
	@Test
	public void get() {
		when().get("https://reqres.in/api/users/2")
		.then().assertThat().statusCode(201).log().all();
	}
}
