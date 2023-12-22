package DataDrivenTesting;

import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRUDWithPOJO.createProjectPOJO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class rmgServer {
	@DataProvider
	public Object[][] rmg() {
		Object[][] obj=new Object[3][4];
		obj[0][0]="ashish";
		obj[0][1]="akart";
		obj[0][2]="active";
		obj[0][3]=10;
		
		obj[1][0]="hemath";
		obj[1][1]="hkart";
		obj[1][2]="on going";
		obj[1][3]=15;
		
		obj[2][0]="sachin";
		obj[2][1]="skart";
		obj[2][2]="completed";
		obj[2][3]=25;
		
		return obj;
	}
	
	@Test(dataProvider = "rmg")
	public void rmgddt(String createdBy, String projectName, String status, int teamSize) {
		baseURI="http://rmgtestingserver";
		port=8084;
		createProjectPOJO cpp = new createProjectPOJO(createdBy, projectName+new Random().nextInt(100), status, teamSize);
		given().body(cpp).contentType(ContentType.JSON).post("/addProject")
		.then().statusCode(201).log().all();
	}
}
