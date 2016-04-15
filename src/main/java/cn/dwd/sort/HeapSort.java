package cn.dwd.sort;

/**
 * 堆排序
 * 1.构造堆
 * 2.从堆顶取出数据。
 * Created by xiaoyanzi on 16/4/13.
 */
public class HeapSort {

    public static void heapSort(int[] a){
    	heapify(a,a.length);
    	SortUtil.print(a);
    	
    	//2.堆里面取出最大的，然后放入最后面的。
    	for(int i = a.length-1;i>0;i--){
    		int temp = a[0];
    		a[0]= a[i];
    		a[i]=temp;
    		siftDown(a,0,i);
    	}
    	SortUtil.print(a);
    }
    
    /**
     * 
     * @param a
     * @param count 有效长度
     */
    private static void heapify(int[] a,int count){
    	//1.构造堆
    	for(int i=count/2-1;i>=0;i--){
    		siftDown(a,i,count);
    	}
    }
    
    private static void siftDown(int[] a, int index,int length){
    	int max = a[index];
    	int left = index*2+1;
    	int right = index*2+2;
    	if(left<length&&a[left]>max){
    		int temp = a[left];
    		a[left] =max;
    		max = temp;
    		a[index]=max;
    		siftDown(a,left,length);
    	}
    	if(right<length&&a[right]>max){
    		int temp = a[right];
    		a[right]=max;
    		max = temp;
    		a[index]=max;
    		siftDown(a,right,length);
    	}
    }
    
    public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		heapSort(a);
	}
}
