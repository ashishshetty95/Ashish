package CRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class deleteProject {
	@Test
	public void delete() {
		when()
		.delete("http://rmgtestingserver:8084/projects/TY_PROJ_1226")
		.then().assertThat().statusCode(204).log().all();

	}
}
