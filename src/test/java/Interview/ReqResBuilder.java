package Interview;

import java.util.Random;

import org.testng.annotations.Test;

import CRUDWithPOJO.createProjectPOJO;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.*;

public class ReqResBuilder {
	@Test
	public void test() {
		createProjectPOJO cpp = new createProjectPOJO("Ashish", "specBuilder"+new Random().nextInt(50), "OnGoing", 10);
		RequestSpecification rsb = new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		ResponseSpecification resp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(201).build();
		
		given().spec(rsb).body(cpp).post("/addProject").then().spec(resp).log().all();
	}
}
