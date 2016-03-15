package cn.dwd.thread;

import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:基于监视器模式的车辆追踪
 * Created by xiaoyanzi on 16/3/16.
 */
@ThreadSafe
public class MonitorVehicleTracker {

    private final Map<String,MutablePoint> locations;

    public MonitorVehicleTracker(Map<String,MutablePoint> locations){
        this.locations = deepcopy(locations);
    }


    public synchronized Map<String,MutablePoint> getLocations(){
        return deepcopy(locations);
    }

    public synchronized MutablePoint getLocation(String id){
        MutablePoint p = locations.get(id);
        return p==null?null:new MutablePoint(p);
    }

    public synchronized void setLocations(String id , int x , int y ){
        MutablePoint p = locations.get(id);
        if(p==null) throw new IllegalArgumentException("No such ID: "+id);
        p.x = x;
        p.y = y;
    }
    private Map<String,MutablePoint> deepcopy(Map<String, MutablePoint> locations) {
        Map<String,MutablePoint> result = new HashMap<String,MutablePoint>();
        if(locations!=null){
            for(String key : locations.keySet()){
                result.put(key,locations.get(key));
            }
        }
        return Collections.unmodifiableMap(result);
    }


    @NotThreadSafe
    class MutablePoint{

        public int x,y;

        public MutablePoint(){}
        public MutablePoint(MutablePoint p){
            this.x = p.x;
            this.y = p.y;
        }
    }
}
