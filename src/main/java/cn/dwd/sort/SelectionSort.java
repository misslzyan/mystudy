package cn.dwd.sort;

import java.net.SocketTimeoutException;

/**
 * 选择排序
 * Created by xiaoyanzi on 16/4/13.
 */
public class SelectionSort {

    public static void selectionSort(int[] a){
        for(int i =0;i<a.length;i++){
            int min = Integer.MAX_VALUE;
            int k = 0;
            for(int j=i;j<a.length;j++){
                if(min>a[j]){
                    min=a[j];
                    k=j;
                }
            }
            //最小的跟第一个数字进行交换
            int temp = a[i];
            a[i]=a[k];
            a[k]=temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        selectionSort(a);
        SortUtil.print(a);
    }
}
