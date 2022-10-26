package com.singleton.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 14:45
 */
public class DoubleLockSingleton {
    private static volatile DoubleLockSingleton instance;

    private DoubleLockSingleton() {

    }

    public static DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleLockSingleton.class) {
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }

        return instance;
    }
}
