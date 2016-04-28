package cn.dwd.designpattern.create_pattern.prototypepattern;

/**
 *
 * Created by xiaoyanzi on 16/4/28.
 */
public class ConcretePrototype2 implements Prototype{
    @Override
    public Prototype clone() {
        return new ConcretePrototype2();
    }
}
