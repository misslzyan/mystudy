package cn.dwd.sqlpattern.parse;

/**
 * 描述：树
 * author: bjduanweidong
 * date: 2016/10/19
 */
public class LogicTree {

    /**
     * 数的根结点
     */
    private Node root;


    static class Node{

        private Node left;

        private Node right;

        private String data;

        private LogicType logicType;
    }
    enum LogicType{
        And(1),
        Or(2);
        private int type;

        LogicType(int type) {
            this.type = type;
        }
    }
}
