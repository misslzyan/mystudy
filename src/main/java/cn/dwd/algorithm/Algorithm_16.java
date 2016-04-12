package cn.dwd.algorithm;

/**
 * 描述:输出9*9口诀
 * @author weidongduan
 *
 */
public class Algorithm_16 {
	
	public  static void myAnwser(){
		for(int i=1;i<10;i++){
			for(int j = 1;j<=i;j++){
				System.out.print(j+"*"+i+"="+i*j);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		myAnwser();
	}
}
