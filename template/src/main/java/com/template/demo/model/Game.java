package com.template.demo.model;

/**
 * @author 吴凯斌
 * 创建时间 2023/1/9 23:21
 */
public abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
