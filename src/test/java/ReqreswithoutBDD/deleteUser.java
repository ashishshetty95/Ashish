package ReqreswithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class deleteUser {
	@Test
	public void delete() {
		Response response = RestAssured.delete("https://reqres.in/api/users/2");
		response.then().log().all();
	}
}
