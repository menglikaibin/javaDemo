package com.abs.factory.demo.domain.factory.model.producer;

import com.abs.factory.demo.domain.factory.AbstractFactory;
import com.abs.factory.demo.domain.factory.ColorFactory;
import com.abs.factory.demo.domain.factory.ShapeFactory;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/23 11:43
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice) {
        if ("Shape".equals(choice)) {
            return new ShapeFactory();
        }
        if ("Color".equals(choice)) {
            return new ColorFactory();
        }

        return null;
    }
}
