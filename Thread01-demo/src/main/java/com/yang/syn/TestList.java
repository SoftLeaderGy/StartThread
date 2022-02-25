package com.yang.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试List 的线程不安全性
 * @Author: Guo.Yang
 * @Date: 2022/02/25/21:05
 */
public class TestList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> list = new ArrayList();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
            Thread.sleep(1);
        }
        System.out.println(list.size());
    }
}
