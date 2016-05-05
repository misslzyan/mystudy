package cn.dwd.designpattern.create_pattern.singleton;

/**
 * 描述:饿汉模式
 * Created by xiaoyanzi on 16/4/27.
 */
public class Test2Class {

    private static Test2Class instance = new Test2Class();

    private Test2Class(){}

    public  static Test2Class getInstance(){
        return instance;
    }
}
