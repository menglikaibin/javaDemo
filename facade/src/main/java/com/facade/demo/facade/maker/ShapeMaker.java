package com.facade.demo.facade.maker;

import com.facade.demo.facade.Shape;
import com.facade.demo.facade.impl.Circle;
import com.facade.demo.facade.impl.Rectangle;

/**
 * @author wuyi
 * @date 2023/7/5
 */
public class ShapeMaker {

    private Shape circle;

    private Shape rectangle;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
    }

    public void drawCircle() {
        circle.draw();
    }

    public void drawRectangle() {
        rectangle.draw();
    }

}
