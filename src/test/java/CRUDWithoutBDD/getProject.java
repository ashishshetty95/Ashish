package CRUDWithoutBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getProject {
	@Test
	public void getPro() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_1120");
		response.then().log().all();
		int scode = response.getStatusCode();
		Assert.assertEquals(scode, 200);
	}
}
