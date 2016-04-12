package cn.dwd.algorithm;

/**
 * 描述：猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个 
 *   第二天早上又将剩下的桃子吃掉一半，又多吃了一个。以后每天早上都吃了前一天剩下   的一半零一个。
 *   到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少
 * @author weidongduan
 *
 */
public class Algorithm_17 {
	
	public static void myAnswer(int day){
		int sum = 1;
		for(int i =day-1 ;i>0;i--){
			sum = (sum+1)*2;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		myAnswer(10);
		myAnswer(1);
		myAnswer(2);
		
	}
}
