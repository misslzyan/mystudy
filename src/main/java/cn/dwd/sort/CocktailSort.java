package cn.dwd.sort;

/**
 * 鸡尾酒排序
 * Created by xiaoyanzi on 16/4/13.
 */
public class CocktailSort {

    public static void cocktailSort(int[] a ){
        int low = 0;
        int high = a.length;
        boolean flag = false;
        while(low<high){
            for(int i = low;i<high-1;i++){
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    flag = true;
                }
            }
            high--;
            SortUtil.print(a);
            if(!flag)break;
            flag =false;
            for(int i = high-1;i>low;i--){
                if(a[i]<a[i-1]){
                    int temp = a[i];
                    a[i]=a[i-1];
                    a[i-1]=temp;
                    flag = true;
                }
            }
            SortUtil.print(a);
            low++;
            if(!flag)break;
            flag = false;
        }

    }

    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1};
        cocktailSort(a);
        SortUtil.print(a);
    }
}
