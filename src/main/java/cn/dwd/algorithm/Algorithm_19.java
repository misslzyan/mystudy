package cn.dwd.algorithm;

/**
 * 描述：打印出菱形
 * @author weidongduan
 *
 */
public class Algorithm_19 {

	/**
	 *
	 * @param n 为奇数
	 */
	public static void myAnwser(int n ){
		if(n%2==0){
			n++;
		}
		for(int i =0;i<n;i++){
			int k = 0;
			for(int j=0;j<n;j++){
				if(i<=n/2){
					if((i+j>=n/2)&&(j-i)<=n/2){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}else{
					int temp = n-i-1;
					if((temp+j>=n/2)&&(j-temp)<=n/2){
						System.out.print("*");
					}else{
						System.out.print(" ");
					}
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		myAnwser(9);
	}
}
