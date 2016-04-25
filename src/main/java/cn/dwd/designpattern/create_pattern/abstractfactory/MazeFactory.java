package cn.dwd.designpattern.create_pattern.abstractfactory;

import cn.dwd.designpattern.create_pattern.old.Door;
import cn.dwd.designpattern.create_pattern.old.Maze;
import cn.dwd.designpattern.create_pattern.old.Room;
import cn.dwd.designpattern.create_pattern.old.Wall;

/**
 * 描述:Maze的创建工厂
 * Created by xiaoyanzi on 16/4/24.
 */
public interface MazeFactory {

    public Room makeRoom(int n);

    Door makeDoor(Room r1, Room r2);

    Wall makeWall();

    Maze makeMaze(int n);

    String createName();
}
