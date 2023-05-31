package com.src.demo;

import com.src.demo.model.Subject;
import com.src.demo.model.observer.BinaryObserver;
import com.src.demo.model.observer.HexObserver;

/**
 * @author 吴凯斌
 * 创建时间 2023/5/31 16:38
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexObserver(subject);

        System.out.println("第一次设置state值,通知观察者,state值为15");
        subject.setState(15);
        System.out.println("第二次设置state值,通知观察者,state值为23");
        subject.setState(23);
    }
}

