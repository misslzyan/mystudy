package cn.dwd.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

/**
 * 桶排序
 * Created by xiaoyanzi on 16/4/12.
 */
public class BucketSort_2 {

	public static final int BUCKET_SIZE = 10;
	
    /**
     * 分为两步,第一步,按照一定的映射,分装到桶内,第二部,每个桶内进行排序
     * @param a
     */
    public static void bucketSort(int[] a){

        /**
         * 这里的每个桶就是一个list
         */
        List<ArrayList<Integer>> bucket =Lists.newArrayList();
        for(int i = 0;i<BUCKET_SIZE;i++){
        	bucket.add(new ArrayList<Integer>());
        }
        for(int i = 0;i<a.length;i++){
        	int key = a[i]/10; //映射公式 将数组a中所有的数字，映射到bucket的桶里面
        	bucket.get(key).add(a[i]);
        }
        
        //在每个桶内部进行排序
        for(int i = 0;i<bucket.size();i++){
        	Collections.sort(bucket.get(i));
        }
        
        for(int i = 0;i<bucket.size();i++){
        	for(Integer temp : bucket.get(i)){
        		System.out.println(temp);
        	}
        }
        
    }
    
    public static void main(String[] args) {
    	int[] a = {9,8,7,6,5,4,3,2,1,34,56,32,64,23,24};
		bucketSort(a);
	}
}
