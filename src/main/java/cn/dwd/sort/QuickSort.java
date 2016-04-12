package cn.dwd.sort;

/**
 * 快速排序
 * @author weidongduan
 *
 */
public class QuickSort {

	/**
	 * 规则：左闭右闭 
	 * 从小到大
	 * @param a
	 * @param begin
	 * @param end
	 */
	public static void quickSort(int a[] , int begin ,int end){
		if(begin+1<end){
			int key = a[begin];
			int low = begin;
			int high = end-1;
			while(low < high){
				//只要大端的数大于标记，就移动位置
				while(low<high&&a[high]>=key){
					high--;
				}
				a[low]=a[high];
				while(low<high&&a[low]<=key){
					low++;
				}
				a[high]=a[low];
			}
			a[low]=key;
			quickSort(a,begin,low);
			quickSort(a,low+1,end);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,4,4,3,6,1};
		quickSort(a, 0, a.length);
		for(int temp : a){
			System.out.println(temp);
		}
	}
}
