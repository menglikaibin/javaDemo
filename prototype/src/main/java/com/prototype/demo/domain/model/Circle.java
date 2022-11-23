package com.prototype.demo.domain.model;

import com.prototype.demo.domain.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/23 15:44
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
