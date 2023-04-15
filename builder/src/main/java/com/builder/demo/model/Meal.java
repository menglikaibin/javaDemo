package com.builder.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0f;

        for (Item item : items) {
            cost += item.price();
        }

        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("item:" + item.name());
            System.out.println(", packing:" + item.packing().pack());
            System.out.println(", price:" + item.price());
        }
    }
}
