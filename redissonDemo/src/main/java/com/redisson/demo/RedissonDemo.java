package com.redisson.demo;

import org.redisson.api.RBloomFilter;

public class RedissonDemo {

    public static void main(String[] args) {

    }

    private static int getData(RBloomFilter<String> bloomFilter, int size) {
        int count = 0;

        for (int i = size; i < size * 2; i++) {
            if (bloomFilter.contains("add" + i)) {
                count ++;
            }
        }

        return count;
    }

    private static void initData(RBloomFilter<String> bloomFilter, int size) {
        bloomFilter.tryInit(size, 0.05);

        for (int i = 0; i < size; i++) {
            bloomFilter.add("add" + i);
        }

        System.out.println("初始化完成");
    }

}
