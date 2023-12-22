package ReqreswithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class fetchUsers {
	@Test
	public void get() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		response.then().log().all();
		
	}
}
