package cn.dwd.designpattern.builder_pattern.old;

/**
 * Created by xiaoyanzi on 16/4/24.
 */
public class Room extends MapSite {

    public Room(int n){
        this.roomNumber = n;
    }

    @Override
    public boolean enter() {
        return true ;
    }

    public int getNum(){
        return roomNumber;
    }

    public void setSide(Direction direction , MapSite mapSite){
        mapSites[direction.val()]=mapSite;
    }

    public MapSite getSide(Direction direction){
        return mapSites[direction.val()];
    }

    private int roomNumber;

    private MapSite[] mapSites= new MapSite[4];
}
