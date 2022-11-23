package com.abs.factory.demo;

import com.abs.factory.demo.domain.factory.AbstractFactory;
import com.abs.factory.demo.domain.factory.model.facade.Color;
import com.abs.factory.demo.domain.factory.model.facade.Shape;
import com.abs.factory.demo.domain.factory.model.producer.FactoryProducer;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 15:59
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("Shape");
        Shape circle = shapeFactory.getShape("Circle");
        circle.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("Color");
        Color red = colorFactory.getColor("Red");
        red.fill();
    }
}
