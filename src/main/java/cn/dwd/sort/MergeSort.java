package cn.dwd.sort;

/**
 * 归并排序 ： 2路归并排序
 * @author weidongduan
 *
 */
public class MergeSort {

	
	public static void mergeSort(int a[]){
		mergeSort(a,0,a.length);
	}

	private static void mergeSort(int[] a, int begin, int end) {
		if(begin+1<end){
			int center = (begin+end)/2;
			mergeSort(a,begin,center);
			mergeSort(a,center,end);
			merge(a,begin,center,end);
		}
		
	}

	private static void merge(int[] a, int begin, int center, int end) {
		int[] temp = new int[end-begin];
		int i =begin;
		int j = center;
		int k = 0;
		for(;i<center&&j<end;){
			if(a[i]<a[j]){
				temp[k++]=a[i++];
				
			}else{
				temp[k++]=a[j++];
				
			}
		}
		while(i<center){
			temp[k++]=a[i++];
		}
		while(j<end){
			temp[k++]=a[j++];
		}
		System.arraycopy(temp, 0, a, begin, temp.length);
		
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		mergeSort(a);
		SortUtil.print(a);
	}
	
}
