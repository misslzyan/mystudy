package cn.dwd.designpattern.builder_pattern.pattern;

import cn.dwd.designpattern.builder_pattern.old.Direction;
import cn.dwd.designpattern.builder_pattern.old.Door;
import cn.dwd.designpattern.builder_pattern.old.Maze;
import cn.dwd.designpattern.builder_pattern.old.Room;

/**
 * 描述:迷宫游戏
 * Created by xiaoyanzi on 16/4/24.
 */
public class MazeGame {

    public Maze createMaze(MazeFactory factory){
        Maze maze = factory.makeMaze();

        Room r1 = factory.makeRoom(1);
        Room r2 = factory.makeRoom(2);

        Door door = factory.makeDoor(r1,r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.West,factory.makeWall());
        r1.setSide(Direction.East,door);
        r1.setSide(Direction.South,factory.makeWall());
        r1.setSide(Direction.North,factory.makeWall());
        r2.setSide(Direction.West,door);
        r2.setSide(Direction.East,factory.makeWall());
        r2.setSide(Direction.South,factory.makeWall());
        r2.setSide(Direction.North,factory.makeWall());

        return maze;

    }
}
