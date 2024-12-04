package com.redisson.demo;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class RedissonDemo {

    private RedissonClient redissonClient;

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

    public void redisLock() throws InterruptedException {
        RLock demoLock = redissonClient.getLock("demoLock");

        boolean isLock = demoLock.tryLock(10, TimeUnit.SECONDS);

        if (isLock) {
            try {
                System.out.println("执行业务");
            } finally {
                demoLock.unlock();
            }
        }
    }

}
