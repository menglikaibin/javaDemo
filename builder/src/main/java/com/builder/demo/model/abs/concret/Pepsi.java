package com.builder.demo.model.abs.concret;

import com.builder.demo.model.abs.ColdDrink;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "pepsi";
    }

    @Override
    public float price() {
        return 5f;
    }
}
