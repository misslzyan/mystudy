package cn.dwd.algorithm.simhash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * MurMurHash算法
 * @author weidongduan
 *
 */
public class MurmurHash {

	
	/**
	 * murmur算法
	 * @param doc
	 * @return
	 */
	public static long hash64(String doc) {
        byte[] buffer = doc.getBytes(Charset.forName("utf-8"));
        ByteBuffer data = ByteBuffer.wrap(buffer);
        return hash64(data, 0, buffer.length, 0);
    }
	
	/**
	 * murmur算法核心
	 * 核心思想：multiply和rotate(旋转)
	 * 就是对于待计算数组里面，每八个字节一组，每位都会进行位运算。保证所有的位都参数hash运算。
	 * @param key
	 * @param offset
	 * @param length
	 * @param seed
	 * @return
	 */
    public static long hash64(ByteBuffer key, int offset, int length, long seed) {
    	//multiply num (solid)
        long m64 = 0xc6a4a7935bd1e995L;
        
        //rotate num (solid)
        int r64 = 47;

        //the result long
        //seed & 0xffffffffL 对于seed，只取低位的四个字节的数。
        //m64 与length相乘。作为基数。
        long h64 = (seed & 0xffffffffL) ^ (m64 * length);

        //处理除了低八个字节以为的字节。
        int lenLongs = length >> 3;

        for (int i = 0; i < lenLongs; ++i) {
            int i_8 = i << 3;

            //取出一组字节里面，含有八个字节。对这八个字节进行拼接，拼接成传到一起的8个字节。
            long k64 = ((long) key.get(offset + i_8) & 0xff) + (((long) key.get(offset + i_8 + 1) & 0xff) << 8) +
                           (((long) key.get(offset + i_8 + 2) & 0xff) << 16) +
                           (((long) key.get(offset + i_8 + 3) & 0xff) << 24) +
                           (((long) key.get(offset + i_8 + 4) & 0xff) << 32) +
                           (((long) key.get(offset + i_8 + 5) & 0xff) << 40) +
                           (((long) key.get(offset + i_8 + 6) & 0xff) << 48) +
                           (((long) key.get(offset + i_8 + 7) & 0xff) << 56);
            
            // multiply
            k64 *= m64;
            //rotate
            k64 ^= k64 >>> r64;
            //multiply
            k64 *= m64;

            h64 ^= k64;
            h64 *= m64;
        }

        int rem = length & 0x7;
        //最低位的八个字节，单独处理，每个字节都结果进行异或处理。保证结果的变动性。
        switch (rem) {
            case 0:
                break;
            case 7:
                h64 ^= (long) key.get(offset + length - rem + 6) << 48;
            case 6:
                h64 ^= (long) key.get(offset + length - rem + 5) << 40;
            case 5:
                h64 ^= (long) key.get(offset + length - rem + 4) << 32;
            case 4:
                h64 ^= (long) key.get(offset + length - rem + 3) << 24;
            case 3:
                h64 ^= (long) key.get(offset + length - rem + 2) << 16;
            case 2:
                h64 ^= (long) key.get(offset + length - rem + 1) << 8;
            case 1:
                h64 ^= (long) key.get(offset + length - rem);
                h64 *= m64;
        }

        h64 ^= h64 >>> r64;
        h64 *= m64;
        h64 ^= h64 >>> r64;

        return h64;
    }
    
    public static void main(String[] args) {
		hash64("我是");
		long a = 0x1324353123412311L;
		
		System.out.println(a&0xff);
	}
}
