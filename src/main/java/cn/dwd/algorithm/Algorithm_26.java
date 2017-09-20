package cn.dwd.algorithm;

/**
 *
 * 素数:证明某一个整数，是否是素数，以及对一个整数进行素数因式分解。
 * 根据定理：任何一个>1的正整数，都可以被分解成多个素数为因子。
 * 证明一个数是素数，只要证明根号n下的所有素数不能整出数N即可。
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_26 {

    public static int[] su= new int[]{2,3,5,7,11,13,17};

    public static void main(String[] args) {
        al(7007);
    }

    /**
     * 如果n是素数，打印“是素数”
     * 如果n是合数，进行因式分解。
     * @param n
     */
    public static void al(int n){
        int t = (int)Math.floor(Math.sqrt(n));
        for(int i = 0 ; i<su.length;i++){
            if(su[i]<t){
                if(n%su[i]==0){
                    //合数
                    yinshi(n);
                    return;
                }
            }else{
                break;
            }
        }
        System.out.println("素数");
    }

    /**
     * 因式分解:合数
     * @param n
     */
    public static void yinshi(int n){
        StringBuilder sb = new StringBuilder();
        int t = n;
        for(int i=0;i<su.length;i++){
            if(su[i]<=t){
                if(n%su[i]==0){
                    sb.append(su[i]).append(",");
                    n=n/su[i];
//                    t = (int)Math.floor(Math.sqrt(n));
                    i--;
                }
                if(n==1){
                    break;
                }
            }else{
                throw new IllegalArgumentException("n");
            }
        }
        System.out.println(sb.toString());
    }
}
