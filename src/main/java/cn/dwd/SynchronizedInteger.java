package cn.dwd;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * 描述:线程安全的类
 * Created by xiaoyanzi on 16/3/13.
 */
@ThreadSafe
public class SynchronizedInteger {

    @GuardedBy("this") private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized void set(int value){
        this.value = value;
    }
}
