package cn.dwd.designpattern.create_pattern.builderpattern;

import cn.dwd.designpattern.create_pattern.old.*;

/**
 * 描述:Default生成器
 * Created by xiaoyanzi on 16/4/25.
 */
public class DefaultMazeBuilder  extends MazeBuilder{

    private Maze maze;

    public DefaultMazeBuilder(){
        this.maze = null;
    }

    @Override
    public void buildMaze(int n) {
        this.maze = new Maze(n);
        this.maze.setName("default builder maze");
    }

    @Override
    public void buildRoom(int n) {
        Room room = new Room(n);

        room.setSide(Direction.East,new Wall());
        room.setSide(Direction.West,new Wall());
        room.setSide(Direction.North,new Wall());
        room.setSide(Direction.South,new Wall());

        maze.addRoom(room);

    }

    @Override
    public void buildDoor(int n1, int n2) {
        Room r1 = maze.roomNo(n1);
        Room r2 = maze.roomNo(n2);

        Door door = new Door(r1,r2);

        r1.setSide(commonOnWall(r1,r2)[0],door);
        r2.setSide(commonOnWall(r1,r2)[1],door);
    }



    @Override
    public Maze getMaze() {
        return maze;
    }

    @Override
    public Direction[] commonOnWall(Room r1, Room r2) {
        return new Direction[]{Direction.East,Direction.West};
    }
}
