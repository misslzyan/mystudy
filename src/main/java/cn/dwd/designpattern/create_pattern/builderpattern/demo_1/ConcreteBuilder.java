package cn.dwd.designpattern.create_pattern.builderpattern.demo_1;

/**
 * 描述:具体的构建者
 * Created by xiaoyanzi on 16/5/1.
 */
public class ConcreteBuilder implements Builder {

    private Product product = new Product();


    public ConcreteBuilder() {
    }

    @Override
    public void buildPart1() {
        product.setPart1("part1");
    }

    @Override
    public void buildPart2() {
        product.setPart2("part2");
    }

    @Override
    public Product retrieveResult() {
        return product;
    }
}
