package cn.dwd.thread;

import net.jcip.annotations.Immutable;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述:不可变对象
 * Created by xiaoyanzi on 16/3/14.
 */
@Immutable
public final class ThreeStooge {
    private final Set<String> stooges = new HashSet<String>();

    public ThreeStooge(){
        stooges.add("stooge1");
        stooges.add("stooge2");
        stooges.add("stooge3");
    }

    public boolean containsStooge(String name){
        return stooges.contains(name);
    }

}
