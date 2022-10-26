package com.strategy.demo.service.impl;

import com.strategy.demo.service.StrategyService;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:08
 */
public class MultiplyStrategyService implements StrategyService {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
