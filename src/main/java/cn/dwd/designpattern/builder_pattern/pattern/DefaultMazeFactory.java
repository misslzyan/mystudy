package cn.dwd.designpattern.builder_pattern.pattern;

import cn.dwd.designpattern.builder_pattern.old.Door;
import cn.dwd.designpattern.builder_pattern.old.Maze;
import cn.dwd.designpattern.builder_pattern.old.Room;
import cn.dwd.designpattern.builder_pattern.old.Wall;

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
    public Maze makeMaze() {
        return new Maze();
    }
}
