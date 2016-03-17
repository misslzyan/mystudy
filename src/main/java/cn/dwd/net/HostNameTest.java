package cn.dwd.net;

import java.net.InetAddress;

public class HostNameTest {
	
	public static void main(String[] args) throws Exception {
		System.out.println(InetAddress.getLocalHost());
		System.out.println(InetAddress.getLoopbackAddress());
	}
}
