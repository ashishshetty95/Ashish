package Validation;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class dynamicResponseReqres {
	@Test
	public void test() {
		String expName="Michael";
		Response response = given().get("https://reqres.in/api/users?page=2");
		List<String> names=response.jsonPath().get("data.first_name");
		boolean flag=false;
		for(String name:names) {
			if (name.equalsIgnoreCase(expName)) {
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		response.then().log().all();
	}
}
