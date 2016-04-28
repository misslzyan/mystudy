package cn.dwd.designpattern.create_pattern.AdapterPattern.typeadapter;

/**
 * 描述:进行适配的类,即适配器
 * Created by xiaoyanzi on 16/4/28.
 */
public class Adapter extends Adaptee implements Target {


    @Override
    public void function2() {
        //实现adaptee中没有的方法.
    }
}
