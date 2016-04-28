package cn.dwd.designpattern.create_pattern.prototypepattern.manage;

/**
 * Created by xiaoyanzi on 16/4/29.
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Prototype p1 = new ConcretePrototype3("lisi");
        ManagePrototype.setPrototype("lisi",p1);
        Prototype p2 = ManagePrototype.getPrototype("lisi").clone();
        p2.setName("lll");
        System.out.println(p1.getName());
        System.out.println(p2.getName());

        Prototype p3 = new ConcretePrototype3("zhangsan");
        ManagePrototype.setPrototype("zhangsan",p3);

        System.out.println(ManagePrototype.getPrototype("zhangsan").clone().getName());
    }
}
