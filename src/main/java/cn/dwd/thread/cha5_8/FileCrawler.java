package cn.dwd.thread.cha5_8;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;


/**
 * 描述:生产者, 负责检索出file
 * Created by xiaoyanzi on 16/3/17.
 */
public class FileCrawler implements Runnable {

    private final BlockingQueue<File> fileQueue;

    private final FileFilter fileFilter;

    private final File root;

    private static Logger logger = Logger.getLogger(FileCrawler.class);

    public FileCrawler(BlockingQueue<File> fileQueue, FileFilter fileFilter, File root) {
        this.fileQueue = fileQueue;
        this.fileFilter = fileFilter;
        this.root = root;
    }

    //
    public void run() {

        try {
            crawl(root);
        } catch (Exception e) {
           logger.error(e.getMessage(),e);
        }

    }

    /**
     * 爬取文件
     * @param root
     */
    private void crawl(File root) {
        File[] files = root.listFiles(fileFilter);
        if(files==null) return;
        for(File file : files){
            if(file.isDirectory()){
                //需要继续解析
                crawl(file);
            }else{
                //需要打印
                try {
                    fileQueue.put(file);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
    }
}
