package ReqreswithBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class getUsers {
	@Test
	public void get() {
		when().get("https://reqres.in/api/users?page=2")
		.then().assertThat().statusCode(200).log().all();
	}
}
