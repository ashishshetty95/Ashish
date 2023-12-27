package GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.Reporter;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {
	Driver driver;
	Connection con;
	
	public void connectDatabase() throws SQLException {
		driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IConstants.DBURL, IConstants.DBUSERNAME, IConstants.DBPASSWORD);
	}
	
	public void closeDatabase() throws SQLException {
		con.close();
	}
	
	public void readDataFromDBAndValidate(String query, int columnIndex, String expData) throws SQLException {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while (result.next()) {
			if (result.getString(columnIndex).equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		Assert.assertTrue(flag);
		Reporter.log("Data is present", true);
	}
	
	public void removeDataFromDatabase(String query, int resultCount) throws SQLException {
		Statement state = con.createStatement();
		int result = state.executeUpdate(query);
		Assert.assertEquals(result, resultCount);
		Reporter.log("Operation is successful", true);
	}
}
