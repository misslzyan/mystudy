package cn.dwd.dht.chord.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

/**
 * 配置管理类
 * Created by xiaoyanzi on 16/10/16.
 */
public class Config {

    private static final Logger logger = Logger.getLogger(Config.class);
    /*端口号*/
    public int PORT;
    /*IP*/
    public String HOST;

    /**
     * 文件名
     */
    public String fileName;

    /**
     * 内容
     */
    public String content;

    public int m;

    private Config(){

    }

    private static class ConfigHandle{
        private static final Config INSTANCE;

        static {
            INSTANCE = new Config();
            INSTANCE.init();
        }
    }

    public static Config getConfig(){
        return ConfigHandle.INSTANCE;
    }

    /**
     * 初始化
     */
    private  void init(){
        logger.info("begin load config ....");
        InputStream is = getClass().getClassLoader().getResourceAsStream("chord/config.properties");
        Properties props = new Properties();
        try {
            props.load(is);
            String port = props.getProperty("port");
            String HOST = props.getProperty("host");
            String fileName = props.getProperty("fileName");
            String content = props.getProperty("content");

            this.HOST = HOST;
            this.PORT = Integer.parseInt(port);
            this.m = Integer.parseInt(props.getProperty("m"));
            this.fileName = fileName;
            this.content = content;
            logger.info("load config success ...");
        } catch (IOException e) {
            logger.error(e.getMessage());
            throw new Error("load properties ");
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }
}
