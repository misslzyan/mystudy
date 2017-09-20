package cn.dwd.algorithm;

/**
 * 构造 B进制展开式
 * Created by bjduanweidong on 2017/9/20.
 */
public class Algorithm_21 {

    public static void main(String[] args) {
        System.out.println(baseBExpansion(12345,8));
        System.out.println(baseBExpansion(177130,16));
        System.out.println(baseBExpansion(241,2));
    }

    /**
     *
     * @param n 十进制数 大于0
     * @param b 基于B的展开式。大于0
     * @return 展开式
     */
    public static String baseBExpansion(int n , int b ){
        if(n<=0 || b <= 0){
            throw  new IllegalArgumentException("n , b ");
        }
        int q = n;
        StringBuilder sb = new StringBuilder();
        while(q!=0){
            sb.append(q % b);
            q = q/b;
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        if(b>10){
            String temp = sb.toString();
            String[] strs = temp.split(",");
            sb.delete(0,sb.length());
            for(int i = strs.length-1;i>=0;i--){
                sb.append(strs[i]);
                if(i!=0)
                sb.append(",");
            }
        }else{
            sb.reverse();
        }
        return sb.toString();
    }
}
