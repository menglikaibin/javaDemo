package com.strategy2.demo;

import com.strategy2.demo.behavior.AddOperation;
import com.strategy2.demo.behavior.MultiplyOperation;
import com.strategy2.demo.behavior.SubtractOperation;

/**
 * @author wuyi
 * @date 2023/7/6
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context1 = new Context(new AddOperation());
        context1.execute(1, 2);

        Context context2 = new Context(new SubtractOperation());
        context2.execute(1, 2);

        Context context3 = new Context(new MultiplyOperation());
        context3.execute(1, 2);
    }
}
