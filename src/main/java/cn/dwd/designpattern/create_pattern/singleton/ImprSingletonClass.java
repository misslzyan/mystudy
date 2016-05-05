package cn.dwd.designpattern.create_pattern.singleton;

/**
 * 描述:懒汉模式的另一种方式
 * Created by xiaoyanzi on 16/4/28.
 */
public class ImprSingletonClass {

    private static ImprSingletonClass instance;

    private Object lock = new Object();

    private ImprSingletonClass(){}

    public static ImprSingletonClass getInstance(){
        if(instance==null){
            synchronized(ImprSingletonClass.class){
                if(instance ==null){
                    instance = new ImprSingletonClass();
                }
            }
        }
        return instance;
    }
}
