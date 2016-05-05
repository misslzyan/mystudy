package cn.dwd.designpattern.create_pattern.builderpattern.demo_1;

/**
 * 描述:建造者模式的Builder抽象接口.
 * Created by xiaoyanzi on 16/5/1.
 */
public interface Builder {

    void buildPart1();

    void buildPart2();

    Product retrieveResult();
}
