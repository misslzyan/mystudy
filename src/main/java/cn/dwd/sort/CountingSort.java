package cn.dwd.sort;

/**
 * 计数排序
 * @author weidongduan
 *
 */
public class CountingSort {
	
	public static void countingSort(int[] a){
		//1.比较出a中各个元素里面，都有几个比自己小的。
		//计数方式分为两种，一种是用双层循环数，另一种是利用分桶进行数，这种方式O(n)
		int max = Integer.MIN_VALUE;
		for(int temp : a){
			if(max<temp){
				max = temp;
			}
		}
		int result[] = new int[a.length];
		int count[] = new int[max+1];
		for(int temp:a){
			count[temp]++;
		}
		for(int i=0;i<count.length;i++){
			if(i>0){
				count[i]=count[i]+count[i-1];
			}
		}
		
		for(int i=0;i<a.length;i++){
			int ttt=count[a[i]];
			try {
				result[count[a[i]]-1]=a[i];
			} catch (Exception e) {
				System.out.println(ttt);
			}
		}
		System.arraycopy(result, 0, a, 0, a.length);
	}
	
	public static void main(String[] args) {
		int[] a = {9,7,6,5,4,3,2,1,8};
		countingSort(a);
		SortUtil.print(a);
	}
}
