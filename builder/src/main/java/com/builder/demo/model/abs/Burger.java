package com.builder.demo.model.abs;

import com.builder.demo.model.Item;
import com.builder.demo.model.Packing;
import com.builder.demo.model.pack.Wrapper;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
