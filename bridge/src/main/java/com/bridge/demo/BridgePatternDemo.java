package com.bridge.demo;

import com.bridge.demo.model.Circle;
import com.bridge.demo.model.concret.GreenCircle;
import com.bridge.demo.model.concret.RedCircle;

/**
 * @author wuyi
 * @date 2023/4/18
 */
public class BridgePatternDemo {
    public static void main(String[] args) {
        Circle greenCircle = new Circle(100, 100, 10, new GreenCircle());
        Circle redCircle = new Circle(100, 100, 10, new RedCircle());

        greenCircle.draw();
        redCircle.draw();
    }
}
