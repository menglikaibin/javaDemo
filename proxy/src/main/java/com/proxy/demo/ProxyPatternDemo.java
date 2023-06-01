package com.proxy.demo;

import com.proxy.demo.domain.ProxyImage;

/**
 * @author 吴凯斌
 * 创建时间 2023/6/1 19:43
 */
public class ProxyPatternDemo {
    public static void main(String[] args) {
        ProxyImage image = new ProxyImage("resources/img.png");
        // 加载文件,再显示文件
        image.display();
        System.out.println("");
        // 直接显示文件
        image.display();
    }
}
