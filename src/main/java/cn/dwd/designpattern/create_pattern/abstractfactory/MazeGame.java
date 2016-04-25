package cn.dwd.designpattern.create_pattern.abstractfactory;

import cn.dwd.designpattern.create_pattern.old.Direction;
import cn.dwd.designpattern.create_pattern.old.Door;
import cn.dwd.designpattern.create_pattern.old.Maze;
import cn.dwd.designpattern.create_pattern.old.Room;

/**
 * 描述:迷宫游戏
 * Created by xiaoyanzi on 16/4/24.
 */
public class MazeGame {

    public Maze createMaze(MazeFactory factory){
        Maze maze = factory.makeMaze(2);

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

        maze.setName(factory.createName());
        return maze;

    }

    public static void main(String[] args) {
        //1.创建一个普通的迷宫
        MazeGame mazeGame = new MazeGame();
        MazeFactory factory1 = new DefaultMazeFactory();
        Maze maze1 = mazeGame.createMaze(factory1);
        System.out.println(maze1.getName());
        //2.创建一个魔法的迷宫

        MazeFactory factory2 = new EnchantMazeFactory();
        Maze maze2 = mazeGame.createMaze(factory2);
        System.out.println(maze2.getName());
    }
}
