package cn.dwd.algorithm;

/**
 * 描述：输入三个整数x,y,z，请把这三个数由小到大输出。
 * @author weidongduan
 *
 */
public class Algorithm_15 {

	public static String anwser(int x,int y , int z){
		StringBuilder sb = new StringBuilder();
		int t = 0;
		if(x>y){
			t=x;
			x=y;
			y=t;
		}
		if(x>z){
			t=x;
			x=z;
			z=t;
		}
		if(y>z){
			t=y;
			y=z;
			z=t;
		}
		sb.append(x);
		sb.append(y);
		sb.append(z);
		return sb.toString();
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(anwser(4, 5, 8));
	}
}
