package cn.dwd.nio;

public class CharSetTest {
	
	public static void main(String[] args)throws Exception {
		String a = "a我是";
		String b = new String(a.getBytes("UTF-8"),"UTF-8");
		System.out.println(b);
	}
}
