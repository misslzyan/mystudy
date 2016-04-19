package cn.dwd.thread.cha7_9;

import java.util.concurrent.TimeUnit;

/**
 * 在专门的线程中中断任务
 * Created by xiaoyanzi on 16/4/15.
 */
public class TheadInterruptThread {

    public static void timedRun(final Runnable r , long timeout , TimeUnit unit)throws InterruptedException{

        class RethrowableTask implements Runnable{

            
            @Override
            public void run() {

            }
        }
    }
}
