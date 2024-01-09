package Mock;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class SerialDeserial {
	
	@Test
	public void simpleSerial() throws JsonGenerationException, JsonMappingException, IOException {
		PojoMockClass pmc = new PojoMockClass("ashish", "trainee");
		ObjectMapper obj = new ObjectMapper();
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./mock/simple.json"), pmc);
	}
	
	@Test 
	public void simpleDeserial() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		PojoMockClass pmc = obj.readValue(new File("./mock/simple.json"), PojoMockClass.class);
		System.out.println(pmc.getName());
		System.out.println(pmc.getJob());
	}
	
	@Test
	public void arraySerial() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		int[] num= {1,2,3};
		PojoArrayMock pam = new PojoArrayMock("ashish", num);
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./mock/array.json"), pam);
	}
	
	@Test
	public void deserialAtaay() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		PojoArrayMock pam = obj.readValue(new File("./mock/array.json"), PojoArrayMock.class);
		System.out.println(pam.getName());
		System.out.println(pam.getNum()[0]);
	}
	
	@Test
	public void serialObject() throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		HashMap map=new HashMap();
		map.put("name", "Anushka");
		map.put("job", "actress");
		PojoObjectMock pom = new PojoObjectMock("Virat", map);
		
		obj.writerWithDefaultPrettyPrinter().writeValue(new File("./mock/object.json"), pom);
	}
	
	@Test
	public void deserialObject() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj=new ObjectMapper();
		PojoObjectMock pom = obj.readValue(new File("./mock/object.json"), PojoObjectMock.class);
		HashMap map = pom.getSpouse();
		System.out.println(pom.getName());
		System.out.println(map.get("name"));
		System.out.println(map.get("job"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
