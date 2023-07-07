package com.chain.demo.model;

/**
 * @author wuyi
 * @date 2023/7/7
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = AbstractLogger.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("error console:" + message);
    }
}
