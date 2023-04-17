package com.bridge.demo.model.concret;

import com.bridge.demo.model.DrawAPI;

/**
 * @author wuyi
 * @date 2023/4/18
 */
public class GreenCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("green, radius:" + radius + ",x:" + x + ",y:" + y);
    }
}
