package com.chain.demo.model;

/**
 * @author wuyi
 * @date 2023/7/7
 */
public class InfoLogger extends AbstractLogger{

    public InfoLogger() {
        this.level = AbstractLogger.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("info console:" + message);
    }
}
