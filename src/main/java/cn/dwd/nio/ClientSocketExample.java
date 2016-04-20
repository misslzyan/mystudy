package cn.dwd.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * nio socket CLIENT
 * 
 * @author weidongduan
 * 
 */
public class ClientSocketExample {

	public void startClient() throws IOException, InterruptedException {
		InetSocketAddress hostAddress = new InetSocketAddress("localhost", 8090);
		SocketChannel client = SocketChannel.open(hostAddress);
		System.out.println("client started ...");
		String threadName = Thread.currentThread().getName();
		// send message to server
		String[] messages = new String[] { threadName + "test1",
				threadName + "test2", threadName + "test3" };
		for (int i = 0; i < messages.length; i++) {
			byte[] message = messages[i].getBytes();
			ByteBuffer buffer = ByteBuffer.wrap(message);
			
			client.write(buffer);
			
			System.out.println(messages[i]);
			buffer.clear();
			Thread.sleep(500);
		}
		client.close();
	}

	public static void main(String[] args) {
		Runnable client = new Runnable() {
			@Override
			public void run() {
				try {
					new ClientSocketExample().startClient();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(client,"Thread-A").start();
	}
}
