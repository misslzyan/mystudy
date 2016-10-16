package cn.dwd.dht.chord.init;

import cn.dwd.dht.chord.config.Config;
import cn.dwd.dht.chord.domain.FileNode;
import cn.dwd.dht.chord.domain.Node;
import cn.dwd.dht.chord.net.NetService;
import cn.dwd.dht.chord.util.ChordUtil;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 初始化chord
 * Created by xiaoyanzi on 16/10/16.
 */
public class InitChord {

    private static final Logger logger = Logger.getLogger(InitChord.class);

    private static Node node;

    public static  void init() throws IOException, NoSuchAlgorithmException {
        Config config = Config.getConfig();
        //初始化负责的文件系统
        Node node = new Node(config.m);
        int a = ChordUtil.shaDegist(config.HOST);
        node.setId(a);
        int port = config.PORT;
        String[] fileNameArray = config.fileName.split(",");
        Map<Integer,FileNode> fileNodeMap = new HashMap<>();
        String[] contentArray = config.content.split(",");
        int count = 0;
        for(String fileName : fileNameArray){
            fileName = fileName+"_"+config.HOST+"_"+config.PORT;
            int key = ChordUtil.shaDegist(fileName);
            FileNode fileNode = new FileNode();
            fileNode.setFileName(fileName);
            fileNode.setContent(contentArray[count++]+"_"+config.HOST+"_"+config.PORT);
            fileNode.setId(key);
            fileNodeMap.put(key,fileNode);
        }
        node.setFileNodeMap(fileNodeMap);
        logger.info(fileNodeMap);
        InitChord.node = node;
        NetService netService = new NetService(port);

    }
}
