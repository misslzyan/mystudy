package cn.dwd.dht.chord.net;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * 网络服务
 * Created by xiaoyanzi on 16/10/16.
 */
public class NetService {

    private ServerSocket serverSocket ;

    public NetService(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }


}
