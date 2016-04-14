package cn.dwd.sort;

/**
 *
 * 奇偶排序
 * Created by xiaoyanzi on 16/4/14.
 */
public class OddEvenSort {

    public static void oddEventSort(int a[]){
        //这种排序,最多需要交换n趟
        for(int i = 0;i<a.length;i++){

            if((i&1)==1){
                //奇数
                for(int j =0;j<a.length-1;j+=2){
                    if(a[j]>a[j+1]){
                        int temp = a[j];
                        a[j]=a[j+1];
                        a[j+1]=temp;
                    }
                }
            }else{
                for(int j =1;j<a.length-1;j+=2){
                    if(a[j]>a[j+1]){
                        int temp = a[j];
                        a[j]=a[j+1];
                        a[j+1]=temp;
                    }
                }

            }
        }
    }

    public static boolean isOdd(int n){
        return (n&1)==1;
    }

    public static void main(String[] args) {
        isOdd(3);
        isOdd(4);
        System.out.println(isOdd(3));
        System.out.println(isOdd(4));
        System.out.println(isOdd(-1));
        int[] a = {9,8,7,6,5,4,3,2,1};
        oddEventSort(a);
        SortUtil.print(a);

        printCode(4);
        printCode(-1);
        printCode(Integer.MAX_VALUE);
        printCode(Integer.MIN_VALUE+1);
    }

    public static void printCode(int a){
        StringBuilder sb = new StringBuilder();
       for(int i =0;i<32;i++){
           sb.append(a>>>i&1);
       }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
