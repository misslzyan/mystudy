package cn.dwd.designpattern.create_pattern.singleton.demo_1;

/**
 * Created by xiaoyanzi on 16/5/2.
 */
public class Singleton {

    private static Singleton instance = null;

    private Singleton(){
        System.out.println("singleton create");
    }

    public static Singleton getInstance(){
        return instance;
    }

    static class SingletonHolder{
        private static Singleton s = new Singleton();


    }


}
