package com.facade.demo.facade.impl;

import com.facade.demo.facade.Shape;

/**
 * @author wuyi
 * @date 2023/7/5
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("draw rectangle");
    }
}
