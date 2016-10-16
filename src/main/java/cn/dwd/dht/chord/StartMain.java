package cn.dwd.dht.chord;

import cn.dwd.dht.chord.config.Config;
import cn.dwd.dht.chord.init.InitChord;
import cn.dwd.dht.chord.net.NetService;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;


/**
 * 启动函数
 * Created by xiaoyanzi on 16/10/16.
 */
public class StartMain {

    private static final Logger logger = Logger.getLogger(StartMain.class);

    public static void main(String[] args) {
        try {
            InitChord.init();
            int port = Config.getConfig().PORT;
            logger.info("chord start success , port is "+port);

        } catch (Exception e) {
            logger.error("start failed",e);
        }
    }
}
