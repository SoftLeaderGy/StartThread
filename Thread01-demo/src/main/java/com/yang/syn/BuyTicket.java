package com.yang.syn;

import lombok.SneakyThrows;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/02/25/21:48
 */
public class BuyTicket{
    public static void main(String[] args) {
        A buyticket = new A();

        new Thread(buyticket, "张").start();
        new Thread(buyticket, "王").start();
        new Thread(buyticket,"李").start();
    }
}

class A implements Runnable{
    private int ticketNums = 10;
    private Boolean flag = true;

    @SneakyThrows
    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }


    public void buy() throws InterruptedException {
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + "拿到了"+ ticketNums--);
    }
}
