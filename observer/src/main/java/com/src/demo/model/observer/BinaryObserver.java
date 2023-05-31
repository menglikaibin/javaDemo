package com.src.demo.model.observer;

import com.src.demo.model.Observer;
import com.src.demo.model.Subject;

/**
 * @author 吴凯斌
 * 创建时间 2023/5/31 17:11
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("二进制字符串:" + Integer.toBinaryString(subject.getState()));
    }
}
