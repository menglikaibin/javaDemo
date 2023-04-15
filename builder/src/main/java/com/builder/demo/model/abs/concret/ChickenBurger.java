package com.builder.demo.model.abs.concret;

import com.builder.demo.model.abs.Burger;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "chicken burger";
    }

    @Override
    public float price() {
        return 50f;
    }
}
