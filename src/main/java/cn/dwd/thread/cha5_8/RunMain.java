package cn.dwd.thread.cha5_8;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 描述:测试
 * Created by xiaoyanzi on 16/3/17.
 */
public class RunMain {
    public static void main(String[] args) throws Exception {
        BlockingQueue<File> queue = new LinkedBlockingDeque<File>(20);
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return true;
            }
        };
        File root = new File("/Users/xiaoyanzi/Documents/code/dwd");
        Thread t1 = new Thread(new FileCrawler(queue,fileFilter,root));
        Thread t2 = new Thread(new Indexer(queue));
        t1.start();
        t2.start();
        Thread t3 = new Thread(new Indexer(queue));
        t3.start();
//        Thread.sleep(1000);
    }
}
