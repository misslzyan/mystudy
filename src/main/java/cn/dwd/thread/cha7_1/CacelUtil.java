package cn.dwd.thread.cha7_1;

import java.util.concurrent.*;

/**
 * 描述:来中断一些任务
 * Created by xiaoyanzi on 16/4/10.
 */
public class CacelUtil {

    private static ThreadPoolExecutor es ;
    static{
        es = new ThreadPoolExecutor(3,3,5,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(3));
        es.allowCoreThreadTimeOut(true);
    }
    public static void timedRun(Runnable r , long timeout , TimeUnit unit) throws InterruptedException{
       Future<?> future  = es.submit(r);
        try {
            future.get(timeout,unit);
        } catch (ExecutionException e) {
//            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        } catch (TimeoutException e) {
            //接下来,任务将被取消
        } finally {
            //如果任务已经结束,那么取消也没什么影响,如果任务还没有结束,就取消任务
            future.cancel(true);
        }

    }

    public static void main(String[] args) {
        try {
            timedRun(new Runnable() {
                @Override
                public void run() {
                    while(!Thread.currentThread().isInterrupted()){
                        try {
                            Thread.sleep(100);
                            System.out.println("====");
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("tuichu");
                }
            },1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
