package com.yang.demo01;

/**
 * 实现多线程模拟并发抢车票案例
 */
public class TestThread04 implements Runnable{

    // 定义车票一共100张票
    private int TICKET = 10;


    @Override
    public void run() {
        while (true) {
            if(TICKET <= 0){
               break;
            }

            // 电脑速度过快，添加延时
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第--->"+ TICKET-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread04 testThread04 = new TestThread04();
        new Thread(testThread04,"小明").start();
        new Thread(testThread04,"小李").start();
        new Thread(testThread04,"小王").start();
    }
}
