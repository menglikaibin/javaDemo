package com.command.demo;

import com.command.demo.model.Broker;
import com.command.demo.model.BuyStockOrder;
import com.command.demo.model.SellStockOrder;
import com.command.demo.model.Stock;

/**
 * @author wuyi
 * @date 2023/7/8
 */
public class CommandPatternDemo {

    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStockOrder buyStockOrder = new BuyStockOrder(stock);
        SellStockOrder sellStockOrder = new SellStockOrder(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }

}
