package com.src.demo.model;

/**
 * @author 吴凯斌
 * 创建时间 2023/5/31 16:54
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();

}
