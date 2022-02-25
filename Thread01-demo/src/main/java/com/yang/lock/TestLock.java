package com.yang.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: 测试lock上锁
 * @Author: Guo.Yang
 * @Date: 2022/02/25/23:19
 */
public class TestLock {

    public static void main(String[] args) {
        buyTicket buyTicket = new buyTicket();

        new Thread(buyTicket,"李").start();
        new Thread(buyTicket,"张").start();
        new Thread(buyTicket,"王").start();
    }
}

class buyTicket implements Runnable{

    private int ticketNums = 100;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticketNums <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
            }finally {
                lock.unlock();
            }
        }
    }
}