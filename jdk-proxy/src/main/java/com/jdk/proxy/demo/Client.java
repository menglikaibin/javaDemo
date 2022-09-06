package com.jdk.proxy.demo;

import com.jdk.proxy.demo.handler.JDKProxyFactory;
import com.jdk.proxy.demo.service.FoodService;
import com.jdk.proxy.demo.service.impl.FoodServiceImpl;

/**
 * @author 吴凯斌
 * 创建时间 2022/9/6 15:30
 */
public class Client {
    public static void main(String[] args) {
        // 创建对象
        FoodServiceImpl foodService = new FoodServiceImpl();
        // 创建代理对象
        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(foodService);
        // 调用代理对象的增强方法,得到增强后的对象
        FoodService proxy = (FoodService) jdkProxyFactory.createProxy();

        proxy.makeChicken();
    }
}
