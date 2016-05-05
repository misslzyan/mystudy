package cn.dwd.designpattern.create_pattern.AdapterPattern.objadapter;

/**
 * 描述:适配器
 * Created by xiaoyanzi on 16/4/28.
 */
public class Adapter implements Target {

    private Adaptee a;

    public Adapter(Adaptee a ){
        this.a = a;
    }

    @Override
    public void fun1() {
        //由a实现
        a.fun();
    }

    @Override
    public void fun2() {
        //自己实现
    }
}
