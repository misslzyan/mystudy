package cn.dwd.designpattern.builder_pattern.pattern;

import cn.dwd.designpattern.builder_pattern.old.Door;
import cn.dwd.designpattern.builder_pattern.old.Maze;
import cn.dwd.designpattern.builder_pattern.old.Room;
import cn.dwd.designpattern.builder_pattern.old.Wall;

/**
 * 描述:Maze的创建工厂
 * Created by xiaoyanzi on 16/4/24.
 */
public interface MazeFactory {

    public Room makeRoom(int n);

    Door makeDoor(Room r1, Room r2);

    Wall makeWall();

    Maze makeMaze();
}
