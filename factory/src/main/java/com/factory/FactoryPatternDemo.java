package com.factory;

import com.factory.domain.factory.ShapeFactory;
import com.factory.domain.factory.model.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 14:28
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        Shape rectangle = shapeFactory.getShape("Rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("Square");
        square.draw();
    }
}
