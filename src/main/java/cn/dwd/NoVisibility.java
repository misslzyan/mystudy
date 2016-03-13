package cn.dwd;

/**
 * 描述:测试多线程中资源的不可见性.
 * Created by xiaoyanzi on 16/3/13.
 */
public class NoVisibility {
    private static boolean ready;
    private static int number ;

    private static class ReaderThread extends Thread{

        @Override
        public void run(){
            while(!ready){
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        ready = true;
        number = 42;
    }
}
