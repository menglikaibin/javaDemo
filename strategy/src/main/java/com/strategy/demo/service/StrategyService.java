package com.strategy.demo.service;

/**
 * @author 吴凯斌
 * 创建时间 2022/10/26 11:02
 */
public interface StrategyService {
    /**
     * 操作
     * @param num1 int
     * @param num2 int
     * @return int
     */
    int doOperation(int num1, int num2);
}
