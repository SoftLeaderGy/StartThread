package com.yang.demo01;

/**
 * 开启多线程方式二
 * 实现Runnable接口，实现多线程
 * 实现Runnable接口、重写run方法、执行线程需要丢入Runnable接口的实现类、调用start方法
 */
public class TestThread03 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我在看书 -->" + i);
        }
    }

    public static void main(String[] args) {
        TestThread03 testThread03 = new TestThread03();

        // 开启线程
        new Thread(testThread03).start();
        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习 -->" + i);
        }
    }
}
