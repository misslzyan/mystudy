package cn.dwd.designpattern.create_pattern.prototypepattern.clone;

import java.io.*;

/**
 * 猴子:
 * Created by xiaoyanzi on 16/4/29.
 */
public class Monkey implements Cloneable,Serializable{

    private String name;

    private int age;

    /**
     * 猴子用的金箍棒
     */
    private Stick s;

    public Monkey(int age, String name, Stick s) {
        this.age = age;
        this.name = name;
        this.s = s;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stick getS() {
        return s;
    }

    public void setS(Stick s) {
        this.s = s;
    }

    /**
     * 浅拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深度拷贝有序列化来做
     * @return
     */
    public Object deepClone() throws Exception{
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(byteOut);
        oo.writeObject(this);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(byteIn);
        return oi.readObject();
    }
}
