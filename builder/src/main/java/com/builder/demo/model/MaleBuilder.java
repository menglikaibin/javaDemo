package com.builder.demo.model;

import com.builder.demo.model.abs.concret.ChickenBurger;
import com.builder.demo.model.abs.concret.Coke;
import com.builder.demo.model.abs.concret.Pepsi;
import com.builder.demo.model.abs.concret.VegBurger;

/**
 * @author wuyi
 * @date 2023/4/15
 */
public class MaleBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.add(new VegBurger());
        meal.add(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.add(new ChickenBurger());
        meal.add(new Pepsi());

        return meal;
    }

}
