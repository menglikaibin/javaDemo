package com.decorator.demo.domain;

import com.decorator.demo.domain.model.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/12/8 23:53
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
