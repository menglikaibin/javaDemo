package com.bridge.demo.model;

/**
 * @author wuyi
 * @date 2023/4/18
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
