package cn.dwd.algorithm;

/**
 * 描述:对一个整数,质数分解
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_4 {

    public static String myAnwser(int n){
        if(n==1){
            return "1";
        }
        for(int i =2;i<=n;i++){
            if(n%i==0){
                if(n==i){
                    return n+"";
                }else{
                    return i+"*"+myAnwser(n/i);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(myAnwser(1));
        myAnwser(1);
        System.out.println(myAnwser(2));
        myAnwser(3);
        System.out.println(myAnwser(4));
        myAnwser(90);
        System.out.println(myAnwser(90));
    }
}
