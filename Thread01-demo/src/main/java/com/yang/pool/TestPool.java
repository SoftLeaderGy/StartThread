package com.yang.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/02/25/23:45
 */
public class TestPool {
    public static void main(String[] args) {
        // 创建服务、创建线程池
        // newFixedThreadPool 参数为线程池的大小
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // 执行
        executor.execute(new test());
        executor.execute(new test());
        executor.execute(new test());
        executor.execute(new test());
        // 关闭链接
        executor.shutdown();
    }
}

class test implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}