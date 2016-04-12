package cn.dwd.sort;

/**
 * 描述：冒泡排序
 * @author weidongduan
 *
 */
public class BubbleSort {
	
	/**
	 * 从大到小
	 * @param a
	 */
	public static void bubblesort(int[] a){
		for(int i =0;i<a.length-1;i++){
			//n-1趟排序
			for(int j=a.length-1;j>i;j--){
				if(a[j]>a[j-1]){
					int temp = a[j];
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		bubblesort(a);
		for(int temp : a){
			System.out.println(temp);
		}
	}
}
