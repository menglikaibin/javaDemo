package com.jdk.proxy.demo.service.impl;

import com.jdk.proxy.demo.service.FoodService;

/**
 * @author 吴凯斌
 * 创建时间 2022/9/6 15:20
 */
public class FoodServiceImpl implements FoodService {
    @Override
    public void makeNoodle() {
        System.out.println("make noodle");
    }

    @Override
    public void makeChicken() {
        System.out.println("make chicken");
    }
}
