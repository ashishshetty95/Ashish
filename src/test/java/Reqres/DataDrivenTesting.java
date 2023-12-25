package Reqres;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataDrivenTesting {

	@DataProvider
	public Object[][] data() {
		Object[][] obj=new Object[4][2];
		
		obj[0][0]="test1";
		obj[0][1]="job1";
		
		obj[1][0]="test2";
		obj[1][1]="job2";
		
		obj[2][0]="test3";
		obj[2][1]="job3";
		
		obj[3][0]="test4";
		obj[3][1]="job4";
		
		return obj;
	}
	
	@Test(dataProvider = "data")
	public void test(String name, String job) {
		POJOClass pojo = new POJOClass(name, job);
		given().body(pojo).contentType(ContentType.JSON)
		.post("https://reqres.in/api/users")
		.then().statusCode(201).log().all();
	}
}
