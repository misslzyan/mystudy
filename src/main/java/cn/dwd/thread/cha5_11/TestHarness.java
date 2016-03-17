package cn.dwd.thread.cha5_11;

import java.util.concurrent.CountDownLatch;

/**
 * 描述:测试闭锁
 * Created by xiaoyanzi on 16/3/17.
 */
public class TestHarness {

    public long timeTask(int nThreads, final Runnable runnable) throws  InterruptedException{
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for(int i = 0;i<nThreads;i++){
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        startGate.await();
                        runnable.run();
                        endGate.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        Thread.sleep(1000);
        long start = System.currentTimeMillis();
        startGate.countDown();
        endGate.await();
        long end = System.currentTimeMillis();
//        System.out.println(end-start);
        return end-start;
    }

    public static void main(String[] args) {
        TestHarness th = new TestHarness();
        try {
           long result =  th.timeTask(4, new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("===");
                }
            });
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
