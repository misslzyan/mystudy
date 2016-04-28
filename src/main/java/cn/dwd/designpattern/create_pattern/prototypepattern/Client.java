package cn.dwd.designpattern.create_pattern.prototypepattern;

/**
 * Created by xiaoyanzi on 16/4/28.
 */
public class Client {

    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public void operation(Prototype example){

        Prototype prototype = example.clone();
    }
}
