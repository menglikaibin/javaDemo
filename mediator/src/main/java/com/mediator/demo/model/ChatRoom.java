package com.mediator.demo.model;

import java.util.Date;

/**
 * @author wuyi
 * @date 2023/7/10
 */
public class ChatRoom {

    public static void showMessage(User user, String message) {
        System.out.println(new Date() + " [" + user.getName() +"] : " + message);
    }

}
