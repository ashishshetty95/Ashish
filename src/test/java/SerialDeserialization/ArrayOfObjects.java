package SerialDeserialization;

import java.io.File;
import java.io.IOException;

import javax.annotation.processing.AbstractProcessor;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJO.PojoArray;

public class ArrayOfObjects {
	@Test
	public void serialise() throws JsonGenerationException, JsonMappingException, IOException {
		int[] phone= {987654321, 321654987, 41258963};
		ObjectMapper omap=new ObjectMapper();
		PojoArray pojo=new PojoArray(101, "Shetty", 28, phone);
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./target/array.json"), pojo);
	}
	
	@Test
	public void deserialise() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		PojoArray data = omap.readValue(new File("./target/array.json"), PojoArray.class);
		System.out.println(data.getId());
		System.out.println(data.getName());
		System.out.println(data.getAge());
		System.out.println(data.getPhone()[2]);
	}
}
