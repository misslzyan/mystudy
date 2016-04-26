package cn.dwd.algorithm.simhash;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * sim哈希算法
 * @author weidongduan
 *
 */
public class SimHash {
	
	
	public static long simHash(String[] chars){
		List<String> list = Lists.newArrayList(chars);
		return simHash(list);
	}
	
	public static long simHash(char[] chars){
		List<String> list = Lists.newArrayList();
		for(int i = 0;i<chars.length;i++){
			list.add(chars[i]+"");
		}
		return simHash(list);
	}
	
	
	/**
	 * simhash描述：
	 * 对于每个词计算出hash值，然后N个词的哈希值进行累加。如果为1，就加weight（代表这个词的权重，如果为0，就-weight）
	 * 然后遍历这几个weight的数组，>0就给1，<0，就给0.正好可以生成64位
	 * @param list 段落分词以后的String集合
	 * @return
	 */
	public static long simHash(List<String> list){
		int[] simArray = new int[64];
		for(String temp : list){
			long code = MurmurHash.hash64(temp);
			for(int i=0;i<64;i++){
				if((code>>i&1)==1){
					//如果是1,就加入权重，此处假设权重为1
					simArray[i]++;
				}else{
					simArray[i]--;
				}
			}
		}
		
		long result = 0x0000000000000000;
		
		long one = 0x00000000000000001;
		
		for(int i =0;i<64;i++){
			if(simArray[i]>0){
				result|=one;
			}
			one = one<<i;
		}
		return result;
	}

}
