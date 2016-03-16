package cn.dwd.thread.cha4_9;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:线程安全的类,注册鼠标和键盘监听器
 * Created by xiaoyanzi on 16/3/16.
 */
public class VisualComponent {

    //线程安全的类
    private final List<String> mouseList = new CopyOnWriteArrayList<String>();

    private final List<String> keyList = new CopyOnWriteArrayList<String>();

    public void addKeyListener(String key){
        keyList.add(key);
    }

    public void removeKeyLister(String key){
        keyList.remove(key);
    }

    public void addMouseListener(String mouse){
        mouseList.add(mouse);
    }

    public void removeMouseListener(String mouse){
        mouseList.remove(mouse);
    }
}



