package DiffWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class HashMapTest {
	@Test
	public void hashMap() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("createdBy", "TYSS");
		map.put("projectName", "Rmg");
		map.put("status", "sdet52");
		map.put("teamSize", 31);
		given().body(map).contentType(ContentType.JSON)
		.when().post("http://rmgtestingserver:8084/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
