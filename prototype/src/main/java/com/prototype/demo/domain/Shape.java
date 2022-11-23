package com.prototype.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2022/11/23 15:36
 */
public abstract class Shape implements Cloneable {

    private String id;

    protected String type;

    public abstract void draw();

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}
