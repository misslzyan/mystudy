package cn.dwd.designpattern.create_pattern.prototypepattern;

/**
 * Created by xiaoyanzi on 16/4/28.
 */
public class ConcretePrototype1 implements Prototype {

    /**
     * 克隆方法的实现
     * @return
     */
    @Override
    public Prototype clone() {
       Prototype temp = new ConcretePrototype1();
        return temp;
    }
}
