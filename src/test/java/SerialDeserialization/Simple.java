package SerialDeserialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJO.PojoSimple;

public class Simple {
	@Test
	public void serialise() throws JsonGenerationException, JsonMappingException, IOException {
		PojoSimple pojo=new PojoSimple(100, "Ashish", 28, "testing");
		ObjectMapper omap=new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./target/simple.json"), pojo);
	}
	
	@Test
	public void deserialise() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		PojoSimple data = omap.readValue(new File("./target/simple.json"), PojoSimple.class);
		System.out.println(data.getId());
		System.out.println(data.getName());
		System.out.println(data.getAge());
		System.out.println(data.getDepartment());
	}
}
