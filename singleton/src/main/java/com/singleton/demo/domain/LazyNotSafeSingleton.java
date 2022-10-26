package com.singleton.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:52
 * 懒汉式(线程不安全)
 */
public class LazyNotSafeSingleton {
    private static LazyNotSafeSingleton instance;

    private LazyNotSafeSingleton() {}

    public static LazyNotSafeSingleton getInstance() {
        if (instance == null) {
            instance = new LazyNotSafeSingleton();
        }

        return instance;
    }
}
