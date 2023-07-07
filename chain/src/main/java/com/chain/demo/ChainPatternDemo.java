package com.chain.demo;

import com.chain.demo.model.AbstractLogger;
import com.chain.demo.model.ErrorLogger;
import com.chain.demo.model.InfoLogger;
import com.chain.demo.model.WarnLogger;

/**
 * @author wuyi
 * @date 2023/7/7
 */
public class ChainPatternDemo {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLogger();

        loggerChain.logMessage(AbstractLogger.INFO, "info information");
        loggerChain.logMessage(AbstractLogger.WARN, "warn information");
        loggerChain.logMessage(AbstractLogger.ERROR, "error information");
    }


    private static AbstractLogger getChainOfLogger() {
        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger warnLogger = new WarnLogger();
        AbstractLogger infoLogger = new InfoLogger();

        errorLogger.setNextLogger(warnLogger);
        warnLogger.setNextLogger(infoLogger);

        return errorLogger;
    }
}
