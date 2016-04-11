package cn.dwd.algorithm;

/**
 * 描述:求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加有键盘控制
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_8 {
    /**
     *
     * @param num  重复的数字
     * @param n   相加数的个数
     * @return
     */
    public static String myAnswer(int num,int n){
        StringBuilder sb = new StringBuilder();
        int jw =0;
        for(int i =n;i>0;i--){
            int a = (num*i+jw)%10;
            jw = (num*i+jw)/10;
            sb.append(a);
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(myAnswer(2,10000));
    }
}
