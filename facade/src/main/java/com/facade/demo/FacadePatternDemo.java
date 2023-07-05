package com.facade.demo;

import com.facade.demo.facade.maker.ShapeMaker;

/**
 * @author wuyi
 * @date 2023/7/5
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
    }
}
