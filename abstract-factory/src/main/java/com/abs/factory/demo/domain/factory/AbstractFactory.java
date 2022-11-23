package com.abs.factory.demo.domain.factory;

import com.abs.factory.demo.domain.factory.model.facade.Color;
import com.abs.factory.demo.domain.factory.model.facade.Shape;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 16:11
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
