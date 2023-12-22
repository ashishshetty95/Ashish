package CRUDWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class getProjects {
	@Test
	public void getProjs() {
		Response response = RestAssured.get("http://rmgtestingserver:8084/projects");
		response.then().log().all();
		int sCode = response.getStatusCode();
		Assert.assertEquals(sCode, 200);
	}
}
