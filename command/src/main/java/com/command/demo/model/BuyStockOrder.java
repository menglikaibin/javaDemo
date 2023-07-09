package com.command.demo.model;

/**
 * @author wuyi
 * @date 2023/7/9
 */
public class BuyStockOrder implements Order {

    private Stock abcStock;

    public BuyStockOrder(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        this.abcStock.buy();
    }

}