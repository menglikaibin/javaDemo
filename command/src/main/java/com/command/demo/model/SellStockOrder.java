package com.command.demo.model;

/**
 * @author wuyi
 * @date 2023/7/9
 */
public class SellStockOrder implements Order {

    private Stock abcStock;

    public SellStockOrder(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        this.abcStock.sell();
    }

}