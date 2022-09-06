package com.cglib.proxy.demo.handler;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 吴凯斌
 * 创建时间 2022/9/6 16:08
 */
public class CglibProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibProxyFactory(Object target) {
        super();
        this.target = target;
    }

    /**
     * 创建代理对象
     * @return Object
     */
    public Object createProxy() {
        // 创建Enhancer
        Enhancer enhancer = new Enhancer();
        // 传递目标对象的class
        enhancer.setSuperclass(target.getClass());
        // 设置回调操作
        enhancer.setCallback(this);

        return enhancer.create();
    }

    //参数一:代理对象;参数二:需要增强的方法;参数三:需要增强方法的参数;参数四:需要增强的方法的代理
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法" + method.getName() + "()方法增强方法前");

        Object invoke = methodProxy.invoke(target, objects);

        System.out.println("方法" + method.getName() + "()方法增强方法后");

        return invoke;
    }
}
