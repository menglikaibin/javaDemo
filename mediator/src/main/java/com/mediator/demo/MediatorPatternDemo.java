package com.mediator.demo;

import com.mediator.demo.model.User;

/**
 * @author wuyi
 * @date 2023/7/10
 */
public class MediatorPatternDemo {

    public static void main(String[] args) {
        User bob = new User("bob");
        User michael = new User("michael");

        bob.sendMessage("hello michael");
        michael.sendMessage("hi bob");
    }

}
