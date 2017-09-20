package cn.dwd.algorithm;

/**
 *
 * 计算b 的n次方， 模 m
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_24 {

    public static void main(String[] args) {
        System.out.println(mod(3,new int[]{0,0,1,0,0,0,0,1,0,1},645));
    }

    /**
     *
     * @param b
     * @param n  n 用二进制数组表示
     * @param m
     * @return
     */
    public static int mod(int b , int[] n , int m){

        int power = b % m;
        int len = n.length;
        int x = 1;
        for(int i=0;i<len;i++ ){
            if(n[i]==1){
                x = (x*power)%m;
            }
            power=(power*power)%m;
        }
        return x;
    }
}
