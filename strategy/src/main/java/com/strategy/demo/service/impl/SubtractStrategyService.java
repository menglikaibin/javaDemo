package com.strategy.demo.service.impl;

import com.strategy.demo.service.StrategyService;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:05
 */
public class SubtractStrategyService implements StrategyService {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
