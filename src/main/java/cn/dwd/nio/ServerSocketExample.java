package cn.dwd.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 描述：nio模式下的server
 * @author weidongduan
 *
 */
public class ServerSocketExample {

	private Selector selector;
	private Map<SocketChannel,List> dataMapper;
	private InetSocketAddress listenAddress;
	
	public ServerSocketExample(String addr , int port){
		this.listenAddress = new InetSocketAddress(addr,port);
		this.dataMapper=new HashMap<SocketChannel,List>();
	}
	
	public static void main(String[] args) {
		Runnable server = new Runnable(){

			@Override
			public void run() {
				try {
					new ServerSocketExample("localhost",8090).startServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}};
		new Thread(server).start();
	}

	protected void startServer() throws IOException{
		this.selector = Selector.open();
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		
		//retrieve the server socket and bind to port
		serverChannel.socket().bind(listenAddress);
		serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
		
		System.out.println("server started ...");
		while(true){
			//wait for events
			this.selector.select();
			
			//work on selected keys
			
			Iterator keys = this.selector.selectedKeys().iterator();
			while(keys.hasNext()){
				SelectionKey key = (SelectionKey)keys.next();
				//this is neccessary to prevent the same key from coming up
				//again the next time around
				keys.remove();
				if(!key.isValid()){
					continue;
				}
				
				if(key.isAcceptable()){
					this.accept(key);
				}else if(key.isReadable()){
					this.read(key);
				}
			}
		}
	}
	
	/**
	 * read from the socket channel
	 * @param key
	 */
	private void read(SelectionKey key) throws IOException {
		SocketChannel channel = (SocketChannel)key.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int numRead = -1;
		numRead = channel.read(buffer);
		if(numRead==-1){
			this.dataMapper.remove(channel);
			Socket socket = channel.socket();
			SocketAddress remoteAddr = socket.getRemoteSocketAddress();
			System.out.println("connection refused by client:"+remoteAddr);
			channel.close();
			key.cancel();
			return;
		}
		byte[] data = new byte[numRead];
//		buffer.flip();
		byte[] mmm = buffer.array();
		System.arraycopy(buffer.array(), 0, data, 0, numRead);
		System.out.println("Got : "+ new String(data));
	}

	/**
	 * accept a connection made to this channel's socket
	 * @param key
	 * @throws IOException
	 */
	private void accept(SelectionKey key)throws IOException {
		 ServerSocketChannel serverChannel = (ServerSocketChannel)key.channel();
		 SocketChannel channel = serverChannel.accept();
		 channel.configureBlocking(false);
		 Socket socket = channel.socket();
		 SocketAddress remoteAddr  = socket.getRemoteSocketAddress();
		 System.out.println("connected to : "+remoteAddr);
		 
		 //register channel with selector for further to
		 dataMapper.put(channel,new ArrayList());
		 channel.register(this.selector, SelectionKey.OP_READ);
	}
}
