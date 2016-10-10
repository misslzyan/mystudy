package cn.dwd.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.util.List;

public class NioInput {
	
	public static void main(String[] args) throws Exception {
	Selector a;	
//		RandomAccessFile raf;
//		URL url = getResource("/1.txt");
//		FileInputStream fin = new FileInputStream(url.getPath());
//		FileChannel fcin = fin.getChannel();
//		ByteBuffer buffer = ByteBuffer.allocate(10);
//		buffer.clear();
//		int r = 0;
//		List<Byte> byteList = Lists.newArrayList();
//		while((r=fcin.read(buffer))!=-1){
//			buffer.flip();
//			byte[] data = buffer.array();
//			data=add(byteList,data);
//			byteList.clear();
////			printCode(data);
//			int len = CharsetUtil.position(data);
//			for(int i = len;i<data.length;i++){
//				byteList.add(data[i]);
//			}
//			String outStr = new String(data,0,len,"UTF-8");
//			System.out.print(outStr);
//		}
		
		test2();
	}

	/**
	 * 描述:合并两个字节数组为一个
	 * @param byteList
	 * @param data
     * @return
     */
	private static byte[] add(List<Byte> byteList, byte[] data) {
		byte[] result = new byte[byteList.size()+data.length];
		for(int i=0;i<byteList.size();i++){
			result[i]=byteList.get(i);
		}
		System.arraycopy(data,0,result,byteList.size(),data.length);
		return result;
	}

	public static URL getResource(String name){
		URL url = NioInput.class.getResource(name);
		System.out.println(url.getPath());
		return url;
	}

	public static void printCode(byte[] a){
		StringBuffer sb = new StringBuffer();
		for(int i = 0;i<a.length;i++){
			for(int j=0;j<8;j++){
				sb.append(a[i]>>j&1);
			}
		}
		System.out.println(sb.reverse());
	}

	
	/**
	 * 测试NIO
	 */
	public static void test2() throws Exception{
		String path = "/2.txt";
		URL url = getResource(path);
		File file = new File(url.getPath());
		RandomAccessFile aFile = new RandomAccessFile(file,"rw");
		
		FileChannel fileChannel = aFile.getChannel();
		
		
		ByteBuffer byteBuffer = ByteBuffer.allocate(2);
		System.out.println(byteBuffer.getClass());
		int byteRead =-1;
		while((byteRead=fileChannel.read(byteBuffer))!=-1){
			byteBuffer.flip();
			while(byteBuffer.remaining()>0){
				System.out.print((char)byteBuffer.get());
			}
			byteBuffer.clear();
		}
		
	}
	
}
