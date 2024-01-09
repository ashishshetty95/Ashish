package Mock;

import java.util.HashMap;

public class PojoObjectMock {
	String name;
	HashMap spouse;
	
	public PojoObjectMock(String name, HashMap spouse) {
		this.name=name;
		this.spouse=spouse;
	}
	
	public PojoObjectMock() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public HashMap getSpouse() {
		return spouse;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setSpouse(HashMap spouse) {
		this.spouse=spouse;
	}
}
