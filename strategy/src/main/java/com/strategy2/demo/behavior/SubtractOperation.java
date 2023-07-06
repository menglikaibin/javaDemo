package com.strategy2.demo.behavior;

/**
 * @author wuyi
 * @date 2023/7/6
 */
public class SubtractOperation implements Strategy {
    @Override
    public void doOperation(Integer num1, Integer num2) {
        System.out.println("num1 - num2:" + (num1 - num2));
    }
}
