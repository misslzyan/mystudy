package cn.dwd.dht.chord.domain;

import cn.dwd.dht.chord.config.Config;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoyanzi on 16/10/16.
 */
public class Node {

    /*前置结点*/
    private Node pre;

    private Node[] finger;

    /*负责内容结点 引用*/
    private Map<Integer,ComponentNode> componentNodeMap;

    /*提供内容结点 物理存储*/
    private Map<Integer,FileNode> fileNodeMap;

    private int id;

    private Config config;

    public Node(int size){
        finger = new Node[size];
    }

    public Node[] getFinger() {
        return finger;
    }

    public void setFinger(Node[] finger) {
        this.finger = finger;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, ComponentNode> getComponentNodeMap() {
        return componentNodeMap;
    }

    public void setComponentNodeMap(Map<Integer, ComponentNode> componentNodeMap) {
        this.componentNodeMap = componentNodeMap;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public Map<Integer, FileNode> getFileNodeMap() {
        return fileNodeMap;
    }

    public void setFileNodeMap(Map<Integer, FileNode> fileNodeMap) {
        this.fileNodeMap = fileNodeMap;
    }
}
