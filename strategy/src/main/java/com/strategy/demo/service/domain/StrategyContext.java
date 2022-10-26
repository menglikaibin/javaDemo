package com.strategy.demo.service.domain;

import com.strategy.demo.service.StrategyService;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:09
 */
public class StrategyContext {
    private StrategyService strategyService;

    public StrategyContext(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    public int executeStrategy(int num1, int num2) {
        return strategyService.doOperation(num1, num2);
    }
}
