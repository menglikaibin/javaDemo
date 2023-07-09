package com.command.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyi
 * @date 2023/7/9
 */
public class Broker {

    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }

        orderList.clear();
    }

}
