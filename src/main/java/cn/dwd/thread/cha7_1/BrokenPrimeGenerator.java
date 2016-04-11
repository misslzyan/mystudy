package cn.dwd.thread.cha7_1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 描述:可以被中断的generator
 * Created by xiaoyanzi on 16/4/10.
 */
public class BrokenPrimeGenerator extends Thread {

    private final BlockingQueue<BigInteger> queue;

    private volatile boolean cacel = false;

    public BrokenPrimeGenerator(BlockingQueue<BigInteger> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(!Thread.currentThread().isInterrupted()){
            try {
                p = p.nextProbablePrime();
                synchronized(this){
                    queue.put(p);
                }
                System.out.println("adfaa");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(this);
                System.out.println(Thread.currentThread());
                Thread.currentThread().interrupt();
//                System.out.println(isInterrupted());
//                System.out.println(isInterrupted());
            } finally {
                System.out.println(Thread.currentThread().isInterrupted());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        }
        System.out.println("退出");

    }

    public void cacel(){
//        this.cacel = true;
        interrupt();
    }

    public void c(Thread t){
        t.interrupt();
    }

    public BlockingQueue<BigInteger> get(){
        return queue;
    }

    public static void main(String[] args) throws  Exception {
        BlockingQueue<BigInteger> queue = new ArrayBlockingQueue<BigInteger>(2);
        BrokenPrimeGenerator brokenPrimeGenerator = new BrokenPrimeGenerator(queue);
        brokenPrimeGenerator.start();
        Thread.sleep(100);
        brokenPrimeGenerator.cacel();
//        System.out.println(Thread.currentThread());
//        System.out.println(Thread.currentThread().isInterrupted());
        for(BigInteger i : brokenPrimeGenerator.get()){
            System.out.println(i.toString());
        }
        Thread.sleep(1000);
        for(BigInteger i : brokenPrimeGenerator.get()){
            System.out.println(i.toString());
        }
    }
}
