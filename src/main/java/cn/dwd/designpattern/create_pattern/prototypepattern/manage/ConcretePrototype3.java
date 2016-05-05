package cn.dwd.designpattern.create_pattern.prototypepattern.manage;


/**
 * Created by xiaoyanzi on 16/4/28.
 */
public class ConcretePrototype3 implements Prototype {

    private String name ;

    public ConcretePrototype3(String name) {
        this.name = name;
    }

    public ConcretePrototype3() {
    }

    @Override
    public Prototype clone() {
        ConcretePrototype3 temp =  new ConcretePrototype3();
        temp.setName(this.name);
        return temp;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
