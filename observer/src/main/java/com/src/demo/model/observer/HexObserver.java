package com.src.demo.model.observer;

import com.src.demo.model.Observer;
import com.src.demo.model.Subject;

/**
 * @author 吴凯斌
 * 创建时间 2023/5/31 17:20
 */
public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("十六进制字符串:" + Integer.toHexString(this.subject.getState()));
    }
}
