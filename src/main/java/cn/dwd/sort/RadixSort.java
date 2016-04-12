package cn.dwd.sort;

/**
 * 描述：基数排序
 * @author weidongduan
 *
 */
public class RadixSort {
	
	public static void radixSort(int[] a){
		
		//定义10个桶
		int[] radix = new int[10];
		for(int i = 0;i<a.length;i++){
			radix[a[i]%10]=a[i];
		}
		
	}
}
