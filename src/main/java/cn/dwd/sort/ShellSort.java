package cn.dwd.sort;

import sun.misc.Sort;

/**
 * 描述:希尔排序
 * Created by xiaoyanzi on 16/4/13.
 */
public class ShellSort {

    public static void shellSort(int[] a){
        //选取关键字,即间隔
        int key = a.length/2;

        while(key>=1){
            for(int i = 0;i<key ; i++){
                for(int j = i+key;j<a.length;j+=key){
                    //进行元素的插入
                    for(int k = i;k<j;k+=key){
                        if(a[j]<a[k]){
                            //依次移动元素.
                            int temp = a[j];
                            for(int m = j;m>k;m-=key){
                                a[m]=a[m-key];
                            }
                            a[k]=temp;
                        }
                    }
                }
            }
            key = key/2;
        }
    }


    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        shellSort(a);
        SortUtil.print(a);
    }
}
