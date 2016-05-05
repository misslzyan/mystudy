package cn.dwd.designpattern.create_pattern.prototypepattern.clone;

import java.io.Serializable;

/**
 * Created by xiaoyanzi on 16/4/29.
 */
public class Stick implements Cloneable,Serializable {

    /**
     * 金箍棒名字
     */
    private String name;

    public Stick(String name) {
        this.name = name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
