package cn.dwd.designpattern.create_pattern.prototypepattern.clone;

/**
 * Created by xiaoyanzi on 16/4/29.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        Stick s = new Stick("stick");

        Monkey m = new Monkey(2,"monkey",s);

        Monkey m2 =(Monkey) m.clone();

        m2.setName("monkey2");
        m2.setAge(3);
        System.out.println(m2.getName()+" "+m2.getAge()+" "+m2.getS());
        System.out.println(m.getName()+" "+m.getAge()+" "+m.getS());


        Monkey m3 =(Monkey) m.deepClone();
        m3.setAge(4);
        m3.setName("monkey3");
        System.out.println(m3.getName()+" "+m3.getAge()+" "+m3.getS()+","+m3.getS().getName());
    }
}
