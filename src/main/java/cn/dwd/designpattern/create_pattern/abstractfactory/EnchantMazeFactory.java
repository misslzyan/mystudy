package cn.dwd.designpattern.create_pattern.abstractfactory;

import cn.dwd.designpattern.create_pattern.old.Door;
import cn.dwd.designpattern.create_pattern.old.Maze;
import cn.dwd.designpattern.create_pattern.old.Room;
import cn.dwd.designpattern.create_pattern.old.Wall;

/**
 * 描述:创建一个魔法迷宫
 * Created by xiaoyanzi on 16/4/25.
 */
public class EnchantMazeFactory implements MazeFactory {


    @Override
    public Room makeRoom(int n) {
        return new EnchantRoom(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1,r2);
    }

    @Override
    public Wall makeWall() {
        return new EnchantWall();
    }

    @Override
    public Maze makeMaze(int n) {
        return new Maze(n);
    }

    @Override
    public String createName() {
        return "enchant maze";
    }
}
