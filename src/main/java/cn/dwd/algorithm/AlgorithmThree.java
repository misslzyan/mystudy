package cn.dwd.algorithm;

/**
 * 描述:打印出所有的 “水仙花数 “，所谓 “水仙花数 “是指一个三位数，
 * 其各位数字立方和等于该数本身。例如：153是一个 “水仙花数 “，
 * 因为153=1的三次方＋5的三次方＋3的三次方。
 * Created by xiaoyanzi on 16/4/11.
 */
public class AlgorithmThree {

    public static void myAnwser(){
        for(int i=100;i<1000;i++){
            int a = i%10;
            int b = (i/10)%10;
            int c = i/100;
            double sum = Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3);
            if(i==sum){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        myAnwser();
    }
}
