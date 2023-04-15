package com.builder.demo.model.abs.concret;

import com.builder.demo.model.abs.ColdDrink;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "coke";
    }

    @Override
    public float price() {
        return 3f;
    }
}
