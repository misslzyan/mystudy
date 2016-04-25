package cn.dwd.designpattern.create_pattern.old;

/**
 * 描述:门
 * Created by xiaoyanzi on 16/4/24.
 */
public class Door  extends MapSite{
    private Room room1;
    private Room room2;
    private boolean isOpen;

    public Door(Room r1 , Room r2){
        this.room1 = r1;
        this.room2 = r2;
    }

    public Room otherSideFrom(Room room){
        if(room == room1 ){
            return room2;
        }else if(room == room2){
            return room1;
        }else{
            return null;
        }

    }

    @Override
    public boolean enter() {
        return isOpen;
    }
}
