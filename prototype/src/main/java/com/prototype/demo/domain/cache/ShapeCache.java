package com.prototype.demo.domain.cache;

import com.prototype.demo.domain.Shape;
import com.prototype.demo.domain.model.Circle;
import com.prototype.demo.domain.model.Rectangle;
import com.prototype.demo.domain.model.Square;

import java.util.Hashtable;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/23 16:23
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

    public static Shape getShape(String shapeId) {
        Shape shape = shapeMap.get(shapeId);

        return (Shape) shape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
