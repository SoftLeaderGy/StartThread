package com.yang.state;

/**
 * @Description: 测试守护线程
 * @Author: Guo.Yang
 * @Date: 2022/02/24/23:01
 */

public class TestDaemon {

    public static void main(String[] args) {
        You you = new You();

        God god = new God();
        // 开启上帝线程
        Thread thread = new Thread(god);
        // 设置上帝线程为守护线程
        thread.setDaemon(true);

        // 开启用户线程
        thread.start();

        //开启用户线程
        new Thread(you).start();
    }
}


// 你（用户进程）
class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("开心的活着");
        }
        System.out.println("==> Good bye World");
    }
}


// 上帝线程（守护线程）
class God implements Runnable {
    @Override
    public void run() {

        // 正常的线程 应该为上帝线程会一直执行下去
        // 但由于是守护线程，也就是用户线程停止后，守护线程会自动结束
        while (true) {
            System.out.println("上帝守护着你");
        }
    }
}