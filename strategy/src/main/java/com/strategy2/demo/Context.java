package com.strategy2.demo;

import com.strategy2.demo.behavior.Strategy;

/**
 * @author wuyi
 * @date 2023/7/6
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategyObj) {
        this.strategy = strategyObj;
    }

    public void execute(Integer num1, Integer num2) {
        strategy.doOperation(num1, num2);
    }
}
