package com.cglib.proxy.demo;

import com.cglib.proxy.demo.handler.CglibProxyFactory;
import com.cglib.proxy.demo.service.FoodService;
import com.cglib.proxy.demo.service.impl.FoodServiceImpl;

/**
 * @author 吴凯斌
 * 创建时间 2022/9/6 17:36
 */
public class Client {
    public static void main(String[] args) {
        // 创建对象
        FoodServiceImpl foodService = new FoodServiceImpl();
        // 创建代理对象
        CglibProxyFactory cglibProxyFactory = new CglibProxyFactory(foodService);
        // 调用代理对象的增强方法,得到增强之后的对象
        FoodService proxy = (FoodService) cglibProxyFactory.createProxy();

        proxy.makeNoodle();
    }
}
