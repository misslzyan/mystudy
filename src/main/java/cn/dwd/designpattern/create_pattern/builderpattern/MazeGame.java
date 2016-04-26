package cn.dwd.designpattern.create_pattern.builderpattern;

import cn.dwd.designpattern.create_pattern.old.Maze;

/**
 * builder patter的迷宫客户调用者
 * Created by xiaoyanzi on 16/4/25.
 */
public class MazeGame {

    public Maze createMaze(MazeBuilder builder){
        builder.buildMaze(2);
        builder.buildRoom(1);
        builder.buildRoom(2);
        builder.buildDoor(1,2);
        return builder.getMaze();
    }

    public static void main(String[] args) {
        MazeGame mazeGame = new MazeGame();
        MazeBuilder builder = new DefaultMazeBuilder();
        Maze maze = mazeGame.createMaze(builder);
        System.out.println(maze.getName());
    }
}
