package com.concurrent.demo;

public class TicketDemo {

    static Object lock = new Object();

    int ticketNumber = 10;

    public void getTicket() {
        synchronized (lock) {
            if (ticketNumber <= 0) {
                return;
            }

            System.out.println(Thread.currentThread().getName() + "抢到一张票，剩余" + ticketNumber);

            ticketNumber--;
        }
    }

    public static void main(String[] args) {
        TicketDemo ticketDemo = new TicketDemo();

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                ticketDemo.getTicket();
            }).start();
        }

    }

}
