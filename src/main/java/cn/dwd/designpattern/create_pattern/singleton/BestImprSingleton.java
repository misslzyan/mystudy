package cn.dwd.designpattern.create_pattern.singleton;

/**
 *懒汉模式的最好的方法
 * Created by xiaoyanzi on 16/4/28.
 */
public class BestImprSingleton {

    private BestImprSingleton(){}

    private static class LazyHolder{
        private static final BestImprSingleton INSTANCE = new BestImprSingleton();
    }

    public static BestImprSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }
}
