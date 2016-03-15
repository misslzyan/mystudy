package cn.dwd.testextends;

public class SubClass extends ParentClass {
		
	public String value  = "subclass";

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
		super.setValue(value);
	}
	
	
}
