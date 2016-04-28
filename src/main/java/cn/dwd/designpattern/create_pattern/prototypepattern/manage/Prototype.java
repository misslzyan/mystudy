package cn.dwd.designpattern.create_pattern.prototypepattern.manage;

/**
 * Created by xiaoyanzi on 16/4/28.
 */
public interface Prototype {

    Prototype clone();

    void setName(String name);

    String getName();

}
