package com.abs.factory.demo.domain.factory;

import com.abs.factory.demo.domain.factory.model.Circle;
import com.abs.factory.demo.domain.factory.model.Rectangle;
import com.abs.factory.demo.domain.factory.model.Square;
import com.abs.factory.demo.domain.factory.model.facade.Color;
import com.abs.factory.demo.domain.factory.model.facade.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 16:11
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        if ("Circle".equals(shape)) {
            return new Circle();
        }

        if ("Rectangle".equals(shape)) {
            return new Rectangle();
        }

        if ("Square".equals(shape)) {
            return new Square();
        }

        return null;
    }
}
