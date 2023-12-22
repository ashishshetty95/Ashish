package Validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponsePath {
	@Test
	public void test() {
		String expId="TY_PROJ_018";
		Response response = when().get("http://rmgtestingserver:8084/projects");
		 List<String> Ids = response.jsonPath().get("projectId");
		 boolean flag=false;
		 for(String id:Ids) {
			 if (expId.equalsIgnoreCase(id)) {
				flag=true;
			}
		 }
		 Assert.assertTrue(flag);
		 response.then().log().all();
	}
}
