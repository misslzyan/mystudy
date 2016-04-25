package cn.dwd.designpattern.create_pattern.old;

/**
 * 描述:生成迷宫
 * 创建迷宫的过程不灵活,不利于扩展.它对迷宫的布局进行了硬编码
 * Created by xiaoyanzi on 16/4/24.
 */
public class MazeGame {

    public Maze createMaze(){
        Maze maze = new Maze(2);
        Room r1 = new Room(1);
        Room r2 = new Room(2);

        Door theDoor = new Door(r1,r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.East,theDoor);
        r1.setSide(Direction.North,new Wall());
        r1.setSide(Direction.South,new Wall());
        r1.setSide(Direction.West,new Wall());

        r2.setSide(Direction.West,theDoor);
        r2.setSide(Direction.North,new Wall());
        r2.setSide(Direction.East,new Wall());
        r2.setSide(Direction.South,new Wall());

        return maze;
    }
}
