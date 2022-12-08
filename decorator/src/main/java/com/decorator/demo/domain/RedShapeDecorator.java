package com.decorator.demo.domain;

import com.decorator.demo.domain.model.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/12/8 23:58
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
