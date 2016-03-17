package cn.dwd.thread.cha5_12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 描述:模拟预加载数据,并用futuretask进行
 * Created by xiaoyanzi on 16/3/17.
 */
public class Preloader {
    private final FutureTask<ProductInfo> futureTask = new FutureTask<ProductInfo>(new Callable<ProductInfo>() {
        public ProductInfo call() throws DataloadException,InterruptedException {
            //模拟加载数据
            System.out.println("开始加载数据");
            Thread.sleep(2000);
            System.out.println("数据加载完毕");
            return new ProductInfo();
        }


    });

    private final Thread t = new Thread(futureTask);

    public void start(){
        t.start();
    }

    public ProductInfo get() throws InterruptedException,DataloadException{
        try {
            return futureTask.get();

        } catch (ExecutionException e) {
            Throwable clause = e.getCause();
            if(clause instanceof DataloadException){
                throw (DataloadException) clause;
            }else{
                throw launcherThrowable(clause);
            }

        }
    }

    private static RuntimeException launcherThrowable(Throwable t) {
        if(t instanceof RuntimeException){
            return (RuntimeException)t;

        }else if (t instanceof Error){
            throw (Error)t;
        }else{
            throw new IllegalStateException("not unchecked"+t);
        }
    }

    class ProductInfo{

    }

    class DataloadException extends  Exception{

    }
}
