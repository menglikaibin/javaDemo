package com.decorator.demo;

import com.decorator.demo.domain.RedShapeDecorator;
import com.decorator.demo.domain.model.Circle;
import com.decorator.demo.domain.model.Rectangle;
import com.decorator.demo.domain.model.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/12/8 23:49
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Shape circle = new Circle();
        RedShapeDecorator redCircle = new RedShapeDecorator(new Circle());
        RedShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle with red border");
        redCircle.draw();

        System.out.println("Rectangle with red border");
        redRectangle.draw();
    }
}
