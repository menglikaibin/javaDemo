package com.chain.demo.model;

/**
 * @author wuyi
 * @date 2023/7/7
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int WARN = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }

        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);

}
