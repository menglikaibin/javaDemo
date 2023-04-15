package com.builder.demo.model.pack;

import com.builder.demo.model.Packing;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}
