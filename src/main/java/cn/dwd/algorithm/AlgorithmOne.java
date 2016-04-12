package cn.dwd.algorithm;
/**
 * 
 * 描述：古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少对？
 * @author weidongduan
 * 解释：先列出规律 所经过月数：0123456789101112
　*　兔子对数：1　1　2　3　5　8　13　21　34　55　89　144　233
 *  构成了斐波那契数列，所以解法如下
 *  延伸：有一楼梯共10级，一人每一步要跨一级也可跨二级，某人从第一级走到第十级共有几种不同的走法？
 *  也是斐波那契数列
 */
public class AlgorithmOne {
	
	public static int f(int month){
		if(month==1||month==2){
			//第一个月和第二个月，都是一对兔子
			return 1;
		}
		//第三个月
		return f(month-1)+f(month-2);
	}
	
	
	public static void main(String[] args) {
		System.out.println(f(1));
		System.out.println(f(2));
		System.out.println(f(3));
		System.out.println(f(4));
		System.out.println(f(5));
		System.out.println(f(6));
		System.out.println(f(7));
		System.out.println(f(8));
		System.out.println(f(9));
		System.out.println(f(10));
		System.out.println(f(11));
		System.out.println(f(12));
		System.out.println(f(13));
		System.out.println(f(14));
		System.out.println(f(15));
		System.out.println(f(16));
		System.out.println(f(17));
		System.out.println(f(18));
		System.out.println(f(19));
		System.out.println(f(20));
		System.out.println(f(21));
		System.out.println(f(22));
	}
}
