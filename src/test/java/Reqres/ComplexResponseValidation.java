package Reqres;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComplexResponseValidation {
	@Test
	public void staticResponse() {
		Response resp = when().get("https://reqres.in/api/users?page=2");
		String aname = resp.jsonPath().get("data[0].first_name");
		String ename="Michael";
		Assert.assertEquals(aname, ename);
		System.out.println(aname+"\n"+ename);
		resp.then().log().all();
	}
	
	@Test
	public void dynamicResponse() {
		Response resp = when().get("https://reqres.in/api/users?page=2");
		List<String> names=resp.jsonPath().get("data.first_name");
		String aname="Michael";
		for(String ename:names) {
			if (ename.equalsIgnoreCase(aname)) {
				System.out.println(aname+" is found in reqres");
				break;
			}
		}
		resp.then().log().all();
	}
	
	@Test
	public void requestChaining() {
		Response resp = when().get("https://reqres.in/api/users?page=2");
		int id=resp.jsonPath().get("data[0].id");
		given().pathParam("id1", id)
		.when().get("https://reqres.in/api/users/{id1}").then().log().all();
	}
	
	@Test
	public void responseTimeValidation() {
		POJOClass pojo = new POJOClass("hamcrest matchers", "response time validation");
		given().body(pojo).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().time(Matchers.lessThan(2500l), TimeUnit.MILLISECONDS)
		.log().all();
	}
}
