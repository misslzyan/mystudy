package cn.dwd.algorithm;

/**
 * 描述：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？ 
 * @author weidongduan
 *
 */
public class Altorithm_11 {

	public static void myAnwser(){
		for(int i =1;i<5;i++){
			for(int j=1;j<5;j++){
				for(int k=1;k<5;k++){
					if(i==j||i==k||j==k){
						continue;
					}
					System.out.println(""+i+j+k);
				}
			}
		}
	}
	public static void main(String[] args) {
		myAnwser();
	}
}
