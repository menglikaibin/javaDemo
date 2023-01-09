package com.template.demo.model;

/**
 * @author 吴凯斌
 * 创建时间 2023/1/9 23:33
 */
public class Football extends Game{
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
