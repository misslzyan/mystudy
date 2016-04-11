package cn.dwd.algorithm;

/**
 * 描述:利用条件运算符的嵌套来完成此题：学习成绩> =90分的同学用A表示，
 * 60-89分之间的用B表示，60分以下的用C表示。
 * Created by xiaoyanzi on 16/4/11.
 */
public class Algorithm_5 {

    public static String myAnwser(int n ){
        return n>=90?"A":n>=60?"B":"C";
    }

    public static void main(String[] args) {
        System.out.println(myAnwser(91));
        System.out.println(myAnwser(76));
        System.out.println(myAnwser(55));
    }
}
