package cn.dwd.designpattern.create_pattern.builderpattern.demo_1;

/**
 * 描述:导演Builder构建Product的类
 * Created by xiaoyanzi on 16/5/1.
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
