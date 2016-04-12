package cn.dwd.sort;

/**
 * 描述：桶排序
 * @author weidongduan
 *
 */
public class BucketSort {
	
	public static void buckeySort(int[] a){
		//得到a数组里面的最大值
		int max = Integer.MIN_VALUE;
		for(int i =0;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
			}
		}
		int bucket[] = new int[max+1];
		for(int i = 0;i<a.length;i++){
			bucket[a[i]]++;
		}
		int j = 0;
		for(int i = 0;i<bucket.length;i++){
			while(bucket[i]>0){
				a[j]=i;
				j++;
				bucket[i]--;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,3,3,2,1,1,3,33,4};
		buckeySort(a);
		for(int temp: a){
			System.out.println(temp);
		}
	}
}
