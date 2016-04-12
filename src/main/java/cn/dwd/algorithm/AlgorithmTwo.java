package cn.dwd.algorithm;

import java.math.BigInteger;

/**
 * 
 * 描述：判断101-200之间有多少个素数，并输出
 * @author weidongduan
 *
 */
public class AlgorithmTwo {
	
	/**
	 * 我的解法：
	 */
	public static void method1(){
		for(int i=101;i<201;i++){
			if(cal(i)){
				System.out.println(i);
			}
		}
	}
	
	public static boolean cal(int num){
		for(int i = 2;i<num/2;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	
	
	
	
	/**
	 * 标准解法：判断一个数是否是质数，应该判断从2到这个数的sqrt（），包含sqrt本身，看看是否有被整除
	 * @param args
	 */
	
	public static void method2(){
		for(int i=101;i<201;i++){
			boolean flag = false;
			for(int j = 2;j<=Math.sqrt(i);j++){
				if(i%j==0){
					//不是质数
					flag=true;
					break;
				}
			}
			if(!flag){
				System.out.println(i);
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		method2();
		method1();
		BigInteger b = new BigInteger("100");
		while(true){
			if(b.intValue()>200){
				break;
			}
			b = b.nextProbablePrime();
			System.out.println(b.toString());
		}
	}
}
