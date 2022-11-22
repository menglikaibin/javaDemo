package com.factory.domain.factory.model;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 15:12
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
