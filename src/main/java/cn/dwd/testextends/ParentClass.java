package cn.dwd.testextends;

public class ParentClass {
	
	public String value = "parent";
	
	
	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public void print(){
		System.out.println(value);
	} 
}
