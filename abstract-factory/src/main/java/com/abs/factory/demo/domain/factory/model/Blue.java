package com.abs.factory.demo.domain.factory.model;

import com.abs.factory.demo.domain.factory.model.facade.Color;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/22 16:13
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Blue::fill()");
    }
}
