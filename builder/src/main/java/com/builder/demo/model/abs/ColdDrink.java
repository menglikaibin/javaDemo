package com.builder.demo.model.abs;

import com.builder.demo.model.Item;
import com.builder.demo.model.Packing;
import com.builder.demo.model.pack.Bottle;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
