package cn.dwd.designpattern.create_pattern.singleton;

/**
 * 描述:单例模式
 * 懒汉模式
 * Created by xiaoyanzi on 16/4/27.
 */
public class TestClass {

    private  static TestClass instance;

    private TestClass(){}

    public synchronized static TestClass getInstance(){
        if(instance == null){
            instance = new TestClass();
        }
        return instance;
    }
}
