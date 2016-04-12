package cn.dwd.sort;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 桶排序
 * Created by xiaoyanzi on 16/4/12.
 */
public class BucketSort_2 {

    /**
     * 分为两步,第一步,按照一定的映射,分装到桶内,第二部,每个桶内进行排序
     * @param a
     */
    public static void bucketSort(int[] a){

        /**
         * 这里的每个桶就是一个list
         */
        List<ArrayList<Integer>> bucket = Lists.newArrayList();
    }
}
