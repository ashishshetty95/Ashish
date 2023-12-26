package POJO;

public class PojoSimple {
	int id;
	String name;
	int age;
	String department;
	public PojoSimple(int id, String name, int age, String department) {
		this.id=id;
		this.name=name;
		this.age=age;
		this.department=department;
	}
	
	public PojoSimple() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department=department;
	}
}
