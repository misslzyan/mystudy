package cn.dwd.nio;

import com.google.common.collect.Lists;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.io.FileInputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;

public class NioInput {
	
	public static void main(String[] args) throws Exception {
		URL url = getResource("/1.txt");
		FileInputStream fin = new FileInputStream(url.getPath());
		FileChannel fcin = fin.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(10);
		buffer.clear();
		int r = 0;
		List<Byte> byteList = Lists.newArrayList();
		while((r=fcin.read(buffer))!=-1){
			buffer.flip();
			byte[] data = buffer.array();
			data=add(byteList,data);
			byteList.clear();
//			printCode(data);
			int len = CharsetUtil.position(data);
			for(int i = len;i<data.length;i++){
				byteList.add(data[i]);
			}
			String outStr = new String(data,0,len,"UTF-8");
			System.out.print(outStr);
		}
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

	
}
