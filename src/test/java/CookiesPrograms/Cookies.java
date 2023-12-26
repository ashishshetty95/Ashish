package CookiesPrograms;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.Map.Entry;

public class Cookies {
	@Test
	public void sendCookies() {
		given().cookie("1P_JAR", "2023-12-26-16", "AEC", "Ackid1SkxNPMTDwaaIxj38sLb78kYYVryzQ-SlHfQwH0_1fvvAriVNosPoo")
		.when().get("https://www.google.com")
		.then().log().all();
	}
	
	@Test
	public void fetchCookies() {
		Map<String, String> cookies = when().get("https://www.google.com").getCookies();
		for(Entry<String, String> cookie:cookies.entrySet()) {
			System.out.println(cookie.getKey()+" "+cookie.getValue());
		}
	}
}
