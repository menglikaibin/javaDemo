package com.abs.factory.demo.domain.factory.model;

import com.abs.factory.demo.domain.factory.model.facade.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 15:12
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
