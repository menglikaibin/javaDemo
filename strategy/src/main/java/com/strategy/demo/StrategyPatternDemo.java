package com.strategy.demo;

import com.strategy.demo.service.domain.StrategyContext;
import com.strategy.demo.service.impl.AddStrategyService;
import com.strategy.demo.service.impl.MultiplyStrategyService;
import com.strategy.demo.service.impl.SubtractStrategyService;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:01
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        StrategyContext addContext = new StrategyContext(new AddStrategyService());
        System.out.println("3 + 2 = " + addContext.executeStrategy(3, 2));

        StrategyContext subtractContext = new StrategyContext(new SubtractStrategyService());
        System.out.println("3 - 2 = " + subtractContext.executeStrategy(3, 2));

        StrategyContext multiplyContext = new StrategyContext(new MultiplyStrategyService());
        System.out.println("3 * 2 = " + multiplyContext.executeStrategy(3, 2));
    }
}
