package cn.dwd.nio;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioInput {
	
//	public static void main(String[] args) throws Exception {
//		URL url = getResource("/1.txt");
//		FileInputStream fin = new FileInputStream(url.getPath());
//		FileChannel fcin = fin.getChannel();
//		ByteBuffer buffer = ByteBuffer.allocate(4);
//		buffer.clear();
//		fcin.read(buffer);
//		byte[] a = buffer.array();
//		//10010001100010001110011001100001
//		StringBuffer sb = new StringBuffer();
//		byte[] m = {a[1],a[2],a[3]};
//		System.out.println(new String(m,"UTF-8"));
//		for(int i = 0;i<a.length;i++){
//			
//			for(int j=0;j<8;j++){
////				System.out.print(a[i]>>j&1);
//				sb.append(a[i]>>j&1);
//			}
//		}
//		
//		System.out.println(sb.reverse());
////		Charset charset = Charset.forName("UTF-8");
////		int r = 0;
////		buffer.clear();
////		while((r=fcin.read(buffer))!=-1){
////			buffer.flip();
////			charset.decode(buffer);
////			System.out.println(buffer.remaining());
////			System.out.println(buffer.getChar());
////			System.out.println(buffer.remaining());
////			System.out.println(buffer.getChar());
////			System.out.println(buffer.remaining());
////		}
////		fcin.read(buffer);
////		buffer.flip();
////		System.out.println(charset.decode(buffer));
////		while(buffer.hasRemaining()){
////			System.out.print(buffer.getChar());
////		}
//	}
	
	public static URL getResource(String name){
		URL url = NioInput.class.getResource(name);
		System.out.println(url.getPath());
		return url;
	}
	
	public static void main(String[] args) {
		char c = 'a';
		for(int i =0;i<32;i++){
			System.out.print(c>>>i&1);
		}
	}
	
	
}
