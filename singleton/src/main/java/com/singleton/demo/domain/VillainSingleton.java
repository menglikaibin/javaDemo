package com.singleton.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:54
 */
public class VillainSingleton {
    private static VillainSingleton instance = new VillainSingleton();

    private VillainSingleton() {

    }

    public static VillainSingleton getInstance() {
        return instance;
    }
}
