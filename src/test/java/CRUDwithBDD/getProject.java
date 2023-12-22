package CRUDwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class getProject {
	@Test
	public void get() {
		when()
		.get("http://rmgtestingserver:8084/projects/TY_PROJ_1226")
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
