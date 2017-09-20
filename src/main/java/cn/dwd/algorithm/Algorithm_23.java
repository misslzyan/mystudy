package cn.dwd.algorithm;

/**
 * 计算两个二进制数据的相乘。
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_23 {

    public static void main(String[] args) {
        System.out.println(multiply(new int[]{0,1,1},new int[]{1,0,1}));
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public static long multiply(int[] a ,int[] b){
        int len = a.length;
        int a1 = 0;
        for(int i =0;i<len;i++){
            a1+=a[i]<<i;
        }
        int[] c = new int[len];
        for(int j =0 ;j<len;j++){
            if(b[j]==1){
                c[j]=a1<<j;
            }
        }
        long p = 0;
        for(int j =0;j<len;j++){
            p+=c[j];
        }
        return p;
    }
}
