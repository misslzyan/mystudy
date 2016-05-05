package cn.dwd.designpattern.create_pattern.builderpattern.demo_1;

/**
 * 描述:Builder模式中,具体的CLIENT,指挥Director及Builder相互协作,共同构建Product
 * Created by xiaoyanzi on 16/5/1.
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        director.construct();
        Product p = builder.retrieveResult();
        System.out.println(p.getPart1());
        System.out.println(p.getPart2());
    }
}
