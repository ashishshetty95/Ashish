package Mock;

public class PojoArrayMock {
	String name;
	int[] num;
	
	public PojoArrayMock(String name, int[] num) {
		this.name=name;
		this.num=num;
	}
	
	public PojoArrayMock() {
		
	}
	
	public String getName() {
		return name;
	}
	
	public int[] getNum() {
		return num;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setNum(int[] num) {
		this.num=num;
	}
}
