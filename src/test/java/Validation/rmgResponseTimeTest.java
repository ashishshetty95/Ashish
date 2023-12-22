package Validation;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class rmgResponseTimeTest {
	@Test
	public void test() {
		File file=new File("./data.json");
		given().body(file).contentType(ContentType.JSON).post("http://rmgtestingserver:8084/addProject")
		.then()
		.time(Matchers.lessThan(500l), TimeUnit.MILLISECONDS).log().all();
	}
}
