package cn.dwd.thread.cha5_8;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.concurrent.BlockingQueue;

/**
 * 描述:消费者线程,打印
 * Created by xiaoyanzi on 16/3/17.
 */
public class Indexer implements Runnable {

    private final BlockingQueue<File> queue;

    private volatile boolean stop = false;

    private static Logger logger = Logger.getLogger(Indexer.class);

    public Indexer(BlockingQueue<File> queue){
        this.queue = queue;
    }

    public void stop(){
        this.stop = true;
    }

    public void run() {
        while(!stop){
            try {
                File file = queue.take();
                Thread.sleep(1000);
                System.out.println(file.getAbsolutePath()+"==="+file.getName());
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
