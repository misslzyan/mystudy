package cn.dwd.designpattern.builder_pattern.old;

/**
 *
 * 描述:迷宫
 * Created by xiaoyanzi on 16/4/24.
 */
public class Maze {

    public void addRoom(Room room ){
        rooms[room.getNum()]=room;
    }

    public Room roomNo(int n){
        return rooms[n];
    }

    private Room[] rooms;
}
