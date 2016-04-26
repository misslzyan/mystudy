package cn.dwd.algorithm.simhash;

import com.google.common.collect.Lists;

/**
 *  描述：simhash测试
 * @author weidongduan
 *
 */
public class TestSimHash {

	public static void main(String[] args) {
		String str1 = "我是一只小小鸟";
		String str2 = "我是一只小小鸟小";
		String str3 = "我是一只小小鸟小鸟";
//		SimHash.simHash(str1.toCharArray());
//		SimHash.simHash(new String[]{});
		long sim1 = SimHash.simHash(str1.toCharArray());
		long sim2 = SimHash.simHash(str2.toCharArray());
		long sim3 = SimHash.simHash(str3.toCharArray());
		System.out.println(sim1);
		System.out.println(sim2);
	    System.out.println(sim3);
		System.out.println(HammingDistance.hammingDistance(sim1, sim2));
		System.out.println(HammingDistance.hammingDistance(sim1, sim3));
		System.out.println(HammingDistance.hammingDistance(sim3, sim2));
	}
}
