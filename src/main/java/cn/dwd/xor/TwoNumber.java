package cn.dwd.xor;

/**
 * 一个数组里面有两个数是不一样的,需要找出来
 * Created by xiaoyanzi on 16/10/12.
 */
public class TwoNumber {


    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,5,5,7,4,3,2,1};
        xorFind(array);
    }

    private static void xorFind(int[] array) {
        int a = 0;
        for(int i =0;i<array.length;i++){
            a^=array[i];
        }

        int b = whichisone(a);
        int num1 =0;
        int num2 = 0;
        for(int i=0;i<array.length;i++){
            int c = check(array[i],b);
            if(c==1){
                num1^=array[i];
            }else{
                num2^=array[i];
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    private static int check(int i, int b) {
        return (i>>b)&1;
    }

    private static int whichisone(int a) {
        int count=0;
        while(((a>>count++)&1)==1){
            return count-1;
        }
        return count;
    }
}
