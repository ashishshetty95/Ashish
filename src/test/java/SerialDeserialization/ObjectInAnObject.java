package SerialDeserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import POJO.PojoObject;

public class ObjectInAnObject {
	@Test
	public void serialise() throws JsonGenerationException, JsonMappingException, IOException {
		int[] phone= {9845621, 584125, 587812};
		HashMap spouse=new HashMap();
		spouse.put("name", "Anushka Sharma");
		spouse.put("age", 36);
		spouse.put("phone", phone);
		PojoObject pojo=new PojoObject("Virat Kohli", 35, spouse);
		ObjectMapper omap=new ObjectMapper();
		omap.writerWithDefaultPrettyPrinter().writeValue(new File("./target/object.json"), pojo);
	}
	
	@Test
	public void deserialise() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper omap=new ObjectMapper();
		PojoObject data=omap.readValue(new File("./target/object.json"), PojoObject.class);
		System.out.println(data.getName());
		System.out.println(data.getAge());
		System.out.println(data.getSpouse().get("name"));
		System.out.println(data.getSpouse().get("age"));
		ArrayList phone=(ArrayList)data.getSpouse().get("phone");
		System.out.println(phone.get(0));
		
	}
}
