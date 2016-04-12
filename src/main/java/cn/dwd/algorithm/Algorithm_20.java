package cn.dwd.algorithm;

/**
 * 描述：有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13…求出这个数列的前20项之和。
 * @author weidongduan
 *
 */
public class Algorithm_20 {

	public static void myAnwser(int n){
		double sum = 0;
		double fenzi = 2;
		double fenmu = 1;
		for(int i =0;i<n;i++){
			sum+=(fenzi/fenmu);
			double temp=fenzi;
			fenzi=fenzi+fenmu;
			fenmu=temp;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		myAnwser(1);
		myAnwser(2);
		myAnwser(3);
		myAnwser(20);
	}
}
