package cn.dwd.algorithm;

/**
 * 描述:一球从100米高度自由落下，每次落地后反跳回原高度的一半；
 * 再落下，求它在   第10次落地时，共经过多少米？第10次反弹多高？
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_10 {

    public static void myAnwser(double n,int m){
        double sum = 0;
//        sum+=n;
        double high = n;
        for(int i =0;i<m;i++){
            if(i==0){
                sum+=high;
            }else{
                sum+=high*2;
            }
            high = high/2;

        }
        System.out.println(high);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        myAnwser(100,1);
        myAnwser(100,2);
        myAnwser(100,3);
        myAnwser(100,4);myAnwser(100,5);myAnwser(100,6);myAnwser(100,7);myAnwser(100,8);
        myAnwser(100,9);
        myAnwser(100,100);
    }
}
