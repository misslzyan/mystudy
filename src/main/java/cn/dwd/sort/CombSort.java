package cn.dwd.sort;

/**梳排序:基于冒泡排序的改进
 * Created by xiaoyanzi on 16/4/14.
 */
public class CombSort {

    public static void combSort(int[] a){

        int gap = a.length;
        float shrink = 1.3f;
        boolean swapFlag = false;
        while(gap!=1||!swapFlag){
            gap = (int)(gap/shrink);
            if(gap<1){
                gap = 1;
            }
            for(int i = 0;i+gap<a.length;i++){
                if(a[i]>a[i+gap]){
                    int temp = a[i];
                    a[i]=a[i+gap];
                    a[i+gap]=temp;
                    swapFlag=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {0,9,8,7,6,5,4,3,2,1};
        combSort(a);
        SortUtil.print(a);
    }
}
