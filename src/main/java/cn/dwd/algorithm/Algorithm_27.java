package cn.dwd.algorithm;

/**
 * 找出100以内的所有素数。
 * 埃拉托斯特尼筛法
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_27 {

    public static void main(String[] args) {
        find();
    }

    public static void find() {
        int[] a = new int[100];
        for (int i = 1; i < 100; i++) {
            a[i] = i + 1;
        }
        for (int i = 0; i < a.length; i++) {
            if(a[i]==2||a[i]==3||a[i]==5||a[i]==7){
                continue;
            }
            if (a[i] % 2 == 0) {
                a[i] = 0;
                continue;
            }
            if (a[i] % 3 == 0) {
                a[i] = 0;
                continue;
            }
            if (a[i] % 5 == 0) {
                a[i] = 0;
                continue;
            }
            if (a[i] % 7 == 0) {
                a[i] = 0;
            }
        }
        for(int i=0;i<a.length;i++){
            if(a[i]!=0){
                System.out.println(a[i]);
            }
        }
    }
}
