package cn.dwd.thread;

import java.awt.*;
import java.util.EventListener;

/**
 * 描述:隐式的使用this逸出
 * Created by xiaoyanzi on 16/3/14.
 */
public class ThisEscape {
    public ThisEscape(EventSource source){
        source.registerListener(
                new EventListener(){
                    public void onEvent(Event e){
                        doSomething(e);//this.doSomething(e);
                    }
                }
        );
    }

    public void doSomething(Event e){
        System.out.println("======"+e);
    }
    class EventSource{
        public void registerListener(EventListener event){}
    }
}
