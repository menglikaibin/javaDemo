package com.builder.demo.model.abs.concret;

import com.builder.demo.model.abs.Burger;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "veg burger";
    }

    @Override
    public float price() {
        return 30f;
    }
}
