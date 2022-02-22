package com.yang.demo01;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/02/22/20:13
 */

/**
 * 创建线程类
 * 重写run（）方法
 * 调用start开启线程
 */
public class TestThread01 extends Thread{
    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码--" + i);
        }
    }

    public static void main(String[] args) {

        // 创建一个线程对象
        TestThread01 testThread01 = new TestThread01();

        // 调用start方法开启线程
        testThread01.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习--" + i);
        }
    }
}
