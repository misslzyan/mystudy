package cn.dwd.algorithm.simhash;

/**
 * 海明距离
 * @author weidongduan
 *
 */
public class HammingDistance {

	/**
	 * 海明距离：计算两个二进制串中，不同的位的个数。
	 * 原理：对每个位进行异或操作，统计出为1的个数。
	 * @param a
	 * @param b
	 * @return
	 */
	public static int hammingDistance(long a,long b){
		long c = a^b;//异或操作
		int count = 0;
		for(int i = 0;i<64;i++){
			if((c>>i&1)==1){
				count++;
			}
		}
		return count;
	}
	
	/**
	 * test
	 * @param args
	 */
	public static void main(String[] args) {
		long a = 1;
		long b = 4;
		System.out.println(hammingDistance(a, b));
	}
}
