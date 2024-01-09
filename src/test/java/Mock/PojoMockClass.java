package Mock;

public class PojoMockClass {
	String name;
	String job;
	
	public PojoMockClass(String name, String job) {
		this.name=name;
		this.job=job;
	}
	
	public PojoMockClass() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getJob() {
		return job;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setJob(String job) {
		this.job=job;
	}
}
