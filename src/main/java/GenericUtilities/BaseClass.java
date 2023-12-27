package GenericUtilities;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	public DataBaseUtils dbu=new DataBaseUtils();
	public JavaUtils ju=new JavaUtils();
	public RestAssuredLibrary ral=new RestAssuredLibrary();
	public RequestSpecification reqst;
	public ResponseSpecification resp;
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dbu.connectDatabase();
		reqst=new RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		resp=new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		dbu.closeDatabase();
	}
}
