package cn.dwd.designpattern.create_pattern.prototypepattern.manage;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述:提供对原型的注册
 * Created by xiaoyanzi on 16/4/28.
 */
public class ManagePrototype {

    private static Map<String,Prototype> map = new HashMap<>();

    private  ManagePrototype() {
    }

    /**
     * 注册一个原型
     * @param pid
     * @param prototype
     */
    public static synchronized void setPrototype(String pid , Prototype prototype){
        map.put(pid,prototype);
    }

    /**
     * 注销一个原型
     * @param pid
     */
    public static synchronized void remove(String pid){
        map.remove(pid);
    }

    public static synchronized Prototype getPrototype(String pid)throws Exception{
        Prototype prototype =  map.get(pid);
        if(prototype==null){
            throw new Exception("您希望的原型还没有被注册,或者已经被销毁");
        }
        return prototype;
    }
}
