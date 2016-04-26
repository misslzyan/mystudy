package cn.dwd.designpattern.create_pattern.builderpattern;

import cn.dwd.designpattern.create_pattern.old.Direction;
import cn.dwd.designpattern.create_pattern.old.Door;
import cn.dwd.designpattern.create_pattern.old.Maze;
import cn.dwd.designpattern.create_pattern.old.Room;

/**
 * 描述:生成器模式
 * Created by xiaoyanzi on 16/4/25.
 */
public abstract class MazeBuilder {

    /**
     * 创建一个迷宫
     * @param n
     * @return
     */
    public abstract void buildMaze(int n);

    /**
     * 创建一个room
     * @param n
     * @return
     */
    public abstract void buildRoom(int n);

    /**
     * 创建一个DOOR
     * @param r1
     * @param r2
     * @return
     */
    public abstract void buildDoor(int r1 , int r2);

    /**
     * 返回一个Maze
     * @return
     */
    public abstract Maze getMaze();

    public  abstract Direction[] commonOnWall(Room r1,Room r2);
}
