package com.factory.domain.factory;

import com.factory.domain.factory.model.Circle;
import com.factory.domain.factory.model.Rectangle;
import com.factory.domain.factory.model.Shape;
import com.factory.domain.factory.model.Square;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 15:28
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if ("Circle".equals(shapeType)) {
            return new Circle();
        }

        if ("Rectangle".equals(shapeType)) {
            return new Rectangle();
        }

        if ("Square".equals(shapeType)) {
            return new Square();
        }

        return null;
    }
}
