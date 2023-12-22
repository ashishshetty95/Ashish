package Validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class staticResponseTest {
	@Test
	public void test() {
		String expId="TY_PROJ_003";
		Response response = given().get("http://rmgtestingserver:8084/projects");
		String actId = response.jsonPath().get("[0].projectId");
		Assert.assertEquals(actId, expId);
		response.then().log().all();
	}
}
