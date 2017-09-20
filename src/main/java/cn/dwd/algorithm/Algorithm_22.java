package cn.dwd.algorithm;

/**
 * 两个二进制的整数想加
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_22 {

    public static void main(String[] args) {
        //0101+1101
        System.out.println(addInt(new int[]{1,0,1,0},new int[]{1,0,1,1}));
    }

    /**
     * a 和 b的长度是相等的
     * @param a    二进制整数
     * @param b   二进制整数
     * @return
     */
    public static String addInt(int[] a , int[] b ){
        int c = 0;
        int len = a.length;
        StringBuilder sb = new StringBuilder();

        for(int i =0;i<len;i++){
            int d = (a[i]+b[i]+c)/2;//计算出进制的数
            int s = a[i]+b[i]+c-(d<<1);//计算出当前位
            sb.append(s);
            c = d;
        }
        if(c!=0)
        sb.append(c);
        return sb.reverse().toString();
    }
}
