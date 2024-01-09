package Mock;

import java.io.File;
import java.util.HashMap;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostUsingDifferentWays {
	@Test
	public void create() {
		HashMap map = new HashMap();
		map.put("name", "ashish");
		map.put("job", "trainee");
		given()
		.body(map).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().log().all();
	}
	
	@Test
	public void post() {
		File file=new File("./reqres.json");
		given()
		.body(file).contentType(ContentType.JSON)
		.post("https://reqres.in/api/users").then().log().all();
	}
	
	@Test
	public void pojo() {
		PojoMockClass pmc = new PojoMockClass("ashish", "student");
		given()
		.body(pmc)
		.contentType(ContentType.JSON)
		.post("https://reqres.in/api/users").then().log().all();
	}
}
