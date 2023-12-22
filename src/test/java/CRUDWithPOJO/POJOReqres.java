package CRUDWithPOJO;

import org.testng.annotations.Test;

public class POJOReqres {
	String name;
	String job;
	public POJOReqres(String name, String job) {
		super();
		this.name = name;
		this.job = job;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
}
