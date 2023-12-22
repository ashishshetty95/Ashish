package DiffWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class usingJSONFileReqres {
	@Test
	public void usingJsonFile() {
		baseURI="https://reqres.in/api/users";
		File file=new File("./data.json");
		given().body(file).contentType(ContentType.JSON)
		.when().post(baseURI)
		.then().assertThat().statusCode(201).log().all();
		
		
	}
}
