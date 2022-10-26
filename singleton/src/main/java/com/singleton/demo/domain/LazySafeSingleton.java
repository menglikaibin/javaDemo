package com.singleton.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:52
 */
public class LazySafeSingleton {
    private static LazySafeSingleton instance;

    private LazySafeSingleton() {
        
    }

    public static synchronized LazySafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazySafeSingleton();
        }

        return instance;
    }
}
