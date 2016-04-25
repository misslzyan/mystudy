package cn.dwd.designpattern.create_pattern.old;

/**
 * 描述:方向枚举
 * Created by xiaoyanzi on 16/4/24.
 */
public enum Direction {

    East(0),
    West(1),
    South(2),
    North(3);

    private Direction(int num){
        this.num = num;
    }

    public int val(){
        return num;
    }

    private int num;
}
