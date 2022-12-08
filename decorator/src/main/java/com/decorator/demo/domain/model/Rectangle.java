package com.decorator.demo.domain.model;

/**
 * @author 吴凯斌
 * 创建时间 2022/12/8 23:55
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
