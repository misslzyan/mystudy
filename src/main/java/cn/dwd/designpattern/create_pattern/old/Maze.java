package cn.dwd.designpattern.create_pattern.old;

/**
 *
 * 描述:迷宫
 * Created by xiaoyanzi on 16/4/24.
 */
public class Maze {

    private String name;

    public Maze(int n){
        rooms = new Room[n];
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRoom(Room room ){
        rooms[room.getNum()-1]=room;
    }

    public Room roomNo(int n){
        return rooms[n-1];
    }

    private Room[] rooms;
}
