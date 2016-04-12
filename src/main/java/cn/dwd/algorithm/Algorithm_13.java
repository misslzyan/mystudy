package cn.dwd.algorithm;

/**
 * 描述：一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请问该数是多少？
 * @author weidongduan
 *
 */
public class Algorithm_13 {

	public static void myAnwser(){
		for(int i=0;;i++){
			int sum = i+100;
			int a = (int)Math.sqrt(sum);
			if(a*a!=sum){
				continue;
			}
			sum = i+168;
			int b = (int)Math.sqrt(sum);
			if(b*b!=sum){
				continue;
			}
			System.out.println(i);
			break;
		}
	}
	
	public static void main(String[] args) {
		myAnwser();
//		double a = Math.sqrt(10);
//		System.out.println(a);
//		System.out.println((int)a);
		
		
	}
	
	public static boolean isSqrt(int n){
		int a = (int)Math.sqrt(n);
		return a*a==n;
	}
}
