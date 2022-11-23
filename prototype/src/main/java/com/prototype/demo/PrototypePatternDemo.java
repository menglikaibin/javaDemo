package com.prototype.demo;

import com.prototype.demo.domain.Shape;
import com.prototype.demo.domain.cache.ShapeCache;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/23 15:34
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape shape1 = ShapeCache.getShape("1");
        System.out.println("Shape:" + shape1.getType());

        Shape shape2 = ShapeCache.getShape("2");
        System.out.println("Shape:" + shape2.getType());

        Shape shape3 = ShapeCache.getShape("3");
        System.out.println("Shape:" + shape3.getType());
    }
}
