package cn.dwd;

import net.jcip.annotations.NotThreadSafe;

/**
 * 非线程安全的integer
 * Created by xiaoyanzi on 16/3/13.
 */
@NotThreadSafe
public class MutableInteger {

    private int value;

    public int get(){
        return value;
    }

    public void set(int value){
        this.value = value;
    }

}
