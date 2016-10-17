package cn.dwd.dht.chord.route;

import cn.dwd.dht.chord.config.Config;
import cn.dwd.dht.chord.domain.ComponentNode;
import cn.dwd.dht.chord.domain.FileNode;
import cn.dwd.dht.chord.domain.Node;
import cn.dwd.dht.chord.init.InitChord;
import cn.dwd.dht.chord.util.ChordUtil;

import java.util.Map;

/**
 * 路由方法
 * Created by xiaoyanzi on 16/10/16.
 */
public class RouteMethod {

    /**
     * 查询对key负责的ID
     * @param key
     * @return
     */
    public static int  lookUp(int key){
        Node node = InitChord.node;
        Map<Integer,ComponentNode> map = node.getComponentNodeMap();
        ComponentNode componentNode = map.get(key);
        if(componentNode!=null){
            //此NODE 对此 KEY负责
            return node.getId();
        }else{
            return findSuccessor(key);
        }
    }

    /**
     * 返回 id归属的node
     * @param id
     * @return
     */
    public static int findSuccessor(int id) {
        Node x = findPredecessor(id);
        return x.getFinger()[0].getId();
    }

    /**
     * 找到对id,负责的点
     * @param id
     * @return
     */
    public static Node findPredecessor(int id) {
        Node x = InitChord.node;
        while(!checkInInterval(x.getId(),x.getFinger()[0].getId(),id)){
            //远程调用
            x = ChordUtil.rpcFindClosestPredecessor(x,id);
        }
        return x;
    }

    /**
     * 找到距离ID最近的前面那个结点
     * @param id
     * @return
     */
    public static Node findClosestPredecessor(int id) {
        Node node = InitChord.node;
        int m = node.getFinger().length;
        Node[] fingers = node.getFinger();
        for(int i =m-1;i>0;i++){
            Node tempNode = fingers[i];
            boolean flag = checkInInterval(node.getId(),id,tempNode.getId());
            if(flag){
               return tempNode;
            }
        }
        return node;
    }

    /**
     * 判断在环形结构中,mid是否在before ,last
     * @param before 开始
     * @param last 结束
     * @param mid 中间
     * @return
     */
    public static boolean checkInInterval(int before, int last,int mid) {
        if(last>=before){
            return mid>before&&mid<=last;
        }else{
            Config config = Config.getConfig();
            int tempLast = last+1<<config.m;
            if(mid>before&&mid<=tempLast){
                return true;
            }else if(mid>last){
                return false;
            }else{
                return true;
            }
        }
    }
}
