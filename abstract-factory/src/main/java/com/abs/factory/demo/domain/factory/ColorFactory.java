package com.abs.factory.demo.domain.factory;

import com.abs.factory.demo.domain.factory.model.Blue;
import com.abs.factory.demo.domain.factory.model.Red;
import com.abs.factory.demo.domain.factory.model.facade.Color;
import com.abs.factory.demo.domain.factory.model.facade.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 16:11
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if ("Blue".equals(color)) {
            return new Blue();
        }
        if ("Red".equals(color)) {
            return new Red();
        }
        return null;
    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
