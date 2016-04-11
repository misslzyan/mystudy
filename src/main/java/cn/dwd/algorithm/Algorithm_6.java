package cn.dwd.algorithm;

/**
 * 描述:输入两个正整数m和n，求其最大公约数和最小公倍数。
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_6 {

    public static int[] myAnwser(int m , int n){
        int max = m>n?m:n;
        int a = 0;
        //最小公倍数
        for(int i =max;;i++){
            if(i%m==0&&i%n==0){
                a=i;
                break;
            }
        }
        //最大公约数
        int min = m<n?m:n;
        int b =0;
        if(m==n){
            b=m;
            return new int[]{a,b};
        }

        while(true){
            int mi = max%min;
            if(mi==0){
                b = min;
                break;
            }
            if(min%mi==0){
                b = mi;
                break;
            }
            max = min;
            min = mi;
        }
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        for(int i :myAnwser(32,32)){
            System.out.println(i);
        }
    }
}
