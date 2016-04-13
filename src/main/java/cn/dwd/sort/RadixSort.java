package cn.dwd.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * 描述：基数排序
 * @author weidongduan
 *	给出一批数字，可以按照个十百三个数字位置进行排序。
 *此例子基于桶排序
 */
public class RadixSort {
	
	public static void radixSort(int[] a){
		
		//定义是个桶，每个桶的空间可以是无限的。此处选则100个SIZE
		int[][] bucket = new int[10][100];
		for(int i = 0;i<bucket.length;i++){
			Arrays.fill(bucket[i], -1);
		}
		int[] temp = new int[a.length];
		System.arraycopy(a, 0, temp, 0, a.length);
		for(int i = 0;i<a.length;i++){
			//1.第一个关键词，按照个位进行排序
			int key = a[i]%10;
			//每个桶可以存a数组的下标
			int j = 0;
			for(;;j++){
				if(bucket[key][j]==-1){
					break;
				}
			}
			bucket[key][j]=i;
		}
		int k=0;
		for(int i =0;i<bucket.length;i++){
			int j=0;
			while(true){
				if(bucket[i][j]!=-1){
					a[k++]=temp[bucket[i][j++]];
				}else{
					break;
				}
			}
		}
		
		
	}
	
public static void radixSort2(int[] a){
		
		//定义是个桶，每个桶的空间可以是无限的。此处选则100个SIZE
		int[][] bucket = new int[10][100];
		for(int i = 0;i<bucket.length;i++){
			Arrays.fill(bucket[i], -1);
		}
		int[] temp = new int[a.length];
		System.arraycopy(a, 0, temp, 0, a.length);
		for(int i = 0;i<a.length;i++){
			//2.第2个关键词，按照个位进行排序
			int key = a[i]/10;
			//每个桶可以存a数组的下标
			int j = 0;
			for(;;j++){
				if(bucket[key][j]==-1){
					break;
				}
			}
			bucket[key][j]=i;
		}
		int k=0;
		for(int i =0;i<bucket.length;i++){
			int j=0;
			while(true){
				if(bucket[i][j]!=-1){
					a[k++]=temp[bucket[i][j++]];
				}else{
					break;
				}
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		int[] a ={9,8,7,6,5,4,3,2,1,11,2,3,44,55,66,77};
		radixSort(a);
		for(int temp : a){
			System.out.print(temp+" ");
		}
		radixSort2(a);
		System.out.println();
		for(int temp : a){
			System.out.print(temp+" ");
		}
	}
}
