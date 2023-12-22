package DiffWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class hashMapReqres {
	@Test
	public void usingHashMap() {
		HashMap map = new HashMap();
		map.put("name", "asgdh");
		map.put("job", "bads");
		given().body(map).contentType(ContentType.JSON)
		.when().post("https://reqres.in/api/users")
		.then().assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
	}
}
