package cn.dwd.thread;

import net.jcip.annotations.Immutable;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 描述:交通监控另一种实现
 * Created by xiaoyanzi on 16/3/16.
 */
@ThreadSafe
public class DelegatingVehicleTracker {

    private final ConcurrentMap<String,Point> locations;

    private final Map<String,Point> unmodifyMap;

    public DelegatingVehicleTracker(Map<String,Point> map){
        locations = new ConcurrentHashMap<String,Point>(map);
        unmodifyMap = Collections.unmodifiableMap(locations);
    }

    /**
     * 这个方法的返回值,会实时更新最新数据.因为是同一个map
     * @return
     */
    public Map<String,Point> getlocations(){
        return unmodifyMap;
    }

    /**
     * 这个方法返回值,是实时数据的一个副本.
     * @return
     */
    public Map<String,Point> getLocations(){
        return Collections.unmodifiableMap(new HashMap<String,Point>(locations));
    }

    public Point getLoation(String id){
        return locations.get(id);
    }

    public void setLocation(String id , int x , int y){
        if(locations.replace(id,new Point(x,y))==null)
            throw new IllegalArgumentException("invalid vehicle name:"+id);
    }






    @Immutable
    class Point{
        private final int x;
        private final int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}
