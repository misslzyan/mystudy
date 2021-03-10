package com.dwd.jdk.hashmap;

/**
 * @author duanweidong
 * @version 2021/3/10 13:29
 */
public class TableSizeFor {

    public static void main(String[] args) {
        System.out.println(tableSizeFor(1));
        System.out.println(tableSizeFor(2));
        System.out.println(tableSizeFor(15));
        System.out.println(tableSizeFor(17));
    }

    /**
     * 找出>=cap的最小的2的幂
     * @param cap
     * @return
     */
    public static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n < 0 ? 1 : n + 1;
    }
}
