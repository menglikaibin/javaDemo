package com.jdk.proxy.demo.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 吴凯斌
 * 创建时间 2022/9/6 15:22
 */
public class JDKProxyFactory implements InvocationHandler {

    private Object target;

    public JDKProxyFactory(Object target) {
        super();
        this.target = target;
    }

    public Object createProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();

        return Proxy.newProxyInstance(classLoader, interfaces, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法" + method.getName() + "()增强方法前...");
        Object invoke = method.invoke(target, args);
        System.out.println("方法" + method.getName() + "()增强方法后...");

        return invoke;
    }
}
