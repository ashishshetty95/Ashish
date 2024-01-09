package Mock;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ComplexResponse {
	@Test
	public void staticResponse() {
		Response response = when()
		.get("https://reqres.in/api/users?page=2");
		String actData = response.jsonPath().get("data[0].first_name");
		String expData="Michael";
		Assert.assertEquals(actData, expData);
		response.then().log().all();
	}
	
	@Test
	public void dynamicResponse() {
		Response resp = when()
		.get("https://reqres.in/api/users?page=2");
		List<String> names = resp.jsonPath().get("data.first_name");
		String expName="Byron";
		boolean flag=false;
		for(String name:names) {
			if (name.equalsIgnoreCase(expName)) {
				flag=true;
			}
		}
		Assert.assertTrue(flag);
		resp.then().log().all();
	}
	
	@Test
	public void requestChaining() {
		Response resp = when()
		.get("https://reqres.in/api/users?page=2");
		Object id = resp.jsonPath().get("data[0].id");
		given().pathParam("id", id)
		.when().get("https://reqres.in/api/users/{id}")
		.then().log().all();
	}
}
