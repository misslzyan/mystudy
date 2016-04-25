package cn.dwd.designpattern.create_pattern.abstractfactory;

import cn.dwd.designpattern.create_pattern.old.Door;
import cn.dwd.designpattern.create_pattern.old.Maze;
import cn.dwd.designpattern.create_pattern.old.Room;
import cn.dwd.designpattern.create_pattern.old.Wall;

/**
 *
 * 描述:默认的迷宫及其组件的创建工厂
 * Created by xiaoyanzi on 16/4/24.
 */
public class DefaultMazeFactory implements MazeFactory {


    @Override
    public Room makeRoom(int n) {
        return new Room(n);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        return new Door(r1,r2);
    }

    @Override
    public Wall makeWall() {
        return new Wall();
    }

    @Override
    public Maze makeMaze(int n) {
        return new Maze(n);
    }

    @Override
    public String createName() {
        return "default maze";
    }
}
