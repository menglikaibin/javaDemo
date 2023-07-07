package com.chain.demo.model;

/**
 * @author wuyi
 * @date 2023/7/7
 */
public class WarnLogger extends AbstractLogger {

    public WarnLogger() {
        this.level = AbstractLogger.WARN;
    }

    @Override
    protected void write(String message) {
        System.out.println("warn console:" + message);
    }
}
