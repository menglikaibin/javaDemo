package com.builder.demo;

import com.builder.demo.model.MaleBuilder;
import com.builder.demo.model.Meal;

/**
 * @author 吴凯斌
 * 创建时间 2023/4/14 23:50
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {
        MaleBuilder maleBuilder = new MaleBuilder();
        Meal vegMeal = maleBuilder.prepareVegMeal();
        System.out.println("vegMeal");
        vegMeal.showItems();
        System.out.println("cost:" + vegMeal.getCost());

        System.out.println("==================");

        Meal nonVegMeal = maleBuilder.prepareNonVegMeal();
        System.out.println("nonVegMeal");
        nonVegMeal.showItems();
        System.out.println("cost:" + nonVegMeal.getCost());

    }

}
