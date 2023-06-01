package com.proxy.demo.domain;

/**
 * @author 吴凯斌
 * 创建时间 2023/6/1 19:53
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("文件名称:" + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("加载文件:" + fileName);
    }
}
