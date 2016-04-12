package cn.dwd.sort;

/**
 * 插入 排序
 * @author weidongduan
 *
 */
public class InsertionSort {

	/**
	 * 从小到大
	 * @param a
	 */
	public static void insertionSort(int[] a){
		for(int i = 1;i<a.length;i++){
			for(int j =0;j<i;j++){
				if(a[j]>a[i]){
					//元素移动
					int temp = a[i];
					int k = i;
					while(k>j){
						a[k]=a[k-1];
						k--;
					}
					a[j]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,3,5,4,3,2,1};
		insertionSort(a);
		for(int temp: a){
			System.out.println(temp);
		}
	}
}
