package cn.dwd.thread.cha7_1;

import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:素数生成器,并且可以正常的停止
 * Created by xiaoyanzi on 16/4/10.
 */
public class PrimeGenerator implements Runnable {

    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();

    private volatile boolean cancel=false;


    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while(!cancel){
           p = p.nextProbablePrime();
            synchronized (this){
                primes.add(p);
            }
        }
    }

    public void cancel(){
        this.cancel = true;
    }

    public synchronized List<BigInteger> get(){
        return new ArrayList<BigInteger>(primes);
    }

    public static void main(String[] args) throws Exception {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        Thread.sleep(1000);
        primeGenerator.cancel();
        for(BigInteger b : primeGenerator.get()){
            System.out.println(b.toString());
        }
    }
}
