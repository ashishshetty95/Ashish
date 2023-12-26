package POJO;

import java.util.HashMap;

public class PojoObject {
	String name;
	int age;
	HashMap spouse;
	
	public PojoObject(String name, int age, HashMap spouse) {
		this.name = name;
		this.age = age;
		this.spouse = spouse;
	}
	
	public PojoObject() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public HashMap getSpouse() {
		return spouse;
	}

	public void setSpouse(HashMap spouse) {
		this.spouse = spouse;
	}	
}
