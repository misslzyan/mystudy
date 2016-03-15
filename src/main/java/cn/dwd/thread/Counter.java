package cn.dwd.thread;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 描述:使用java监视器模式的线程安全计数器
 * Created by xiaoyanzi on 16/3/15.
 */
@ThreadSafe
public class Counter {

    @GuardedBy("this") private long value = 0;

    public synchronized long getValue(){
        return value;
    }

    public synchronized long increment(){
        if(value == Long.MAX_VALUE){
            throw new IllegalStateException("counter overflow");

        }
        return ++value;
    }

    public static void main(String[] args) {
        Collections.synchronizedList(new ArrayList<String>());
    }
}
