package cn.dwd.dht.chord.util;

import cn.dwd.dht.chord.domain.Node;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * chord util
 * Created by xiaoyanzi on 16/10/16.
 */
public class ChordUtil {

    private static final Logger logger = Logger.getLogger(ChordUtil.class);

    /**
     * SHA-1
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static int shaDegist(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        byte[] bytes = messageDigest.digest(str.getBytes("UTF-8"));
        byte lastByte = bytes[bytes.length-1];
        int a = lastByte&0x1F;
        return a;
    }

    /**
     * RPC调用
     * @param id
     * @return
     */
    public static Node rpcFindClosestPredecessor(Node node , int id) {
        //进行RPC调用.
        OutputStream out = null;
        InputStream fin = null;
        try {
            int port = node.getConfig().PORT;
            Socket socket = new Socket("localhost",port);
             out = socket.getOutputStream();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("method","findClosestPredecessor");
            jsonObject.put("param",id);
            byte[] b = jsonObject.toJSONString().getBytes("UTF-8");
            out.write(b);
            out.flush();
            fin = socket.getInputStream();
            byte[] rArray = new byte[fin.available()];
            fin.read(rArray);
            String result = new String(rArray,"UTF-8");
            logger.info(result);
            return null;
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            return null;
        }finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(),e);
                }
            }
        }
    }
}
