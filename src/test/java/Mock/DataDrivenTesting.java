package Mock;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DataDrivenTesting {
	@DataProvider
	public Object[][] provide() {
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="ashish";
		obj[0][1]="trainee";
		
		obj[1][0]="sachin";
		obj[1][1]="trainer";
		
		return obj;
	}
	
	@Test(dataProviderClass=Mock.DataDrivenTesting.class, dataProvider = "provide")
	public void reqres(String name, String job) {
		PojoMockClass pmc = new PojoMockClass(name, job);
		given()
		.body(pmc).contentType(ContentType.JSON)
		.post("https://reqres.in/api/users")
		.then().time(Matchers.lessThan(15000l), TimeUnit.MILLISECONDS).log().all();
	}
}
