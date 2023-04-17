package com.bridge.demo.model.concret;

import com.bridge.demo.model.DrawAPI;

/**
 * @author wuyi
 * @date 2023/4/18
 */
public class RedCircle  implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("red, radius:" + radius + ",x:" + x + ",y:" + y);
    }
}
