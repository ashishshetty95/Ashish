package RequestChaining;

import java.io.File;

import org.junit.Assert;
import org.testng.annotations.Test;

import CRUDWithPOJO.createProjectPOJO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class chainingTest {
	@Test
	public void chaining() {
		baseURI="http://rmgtestingserver";
		port=8084;
		createProjectPOJO cpp = new createProjectPOJO("hp", "laptop", "working", 10);
		Response response = given().body(cpp).contentType(ContentType.JSON).post("/addProject");
		String pid = response.jsonPath().get("projectId");
		Response resp = given().pathParam("projectId", pid)
		.when().get("/projects/{projectId}");
		String id=resp.jsonPath().get("projectId");
		Assert.assertEquals(id, pid);
		response.then().log().all();
		resp.then().log().all();
		
	}
}
