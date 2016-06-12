package cn.dwd.designpattern.create_pattern.singleton.demo_1;

import cn.dwd.designpattern.create_pattern.singleton.Test2Class;

/**
 * 描述:测试单例模式
 * Created by xiaoyanzi on 16/5/2.
 */
public class TestClass {

    public static void main(String[] args) throws Exception {
        Class<?> c = TestClass.class.getClassLoader().loadClass("cn.dwd.designpattern.create_pattern.singleton.demo_1.Singleton");
        System.out.println(c.getName());
        Class.forName("cn.dwd.designpattern.create_pattern.singleton.demo_1.Singleton");
//        Singleton.getInstance();
    }

}
