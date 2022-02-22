package com.yang.demo01;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/02/22/20:43
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习Thread ， 实现多线程同步下载图片
 */
@Slf4j
public class TestThread02 extends Thread{

    private String name;
    private String url;
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url , name);
//        log.info("现在文件完成，文件名为--" + name);
        System.out.println("现在文件完成，文件名为--"+ name);
    }

    public static void main(String[] args) {
        TestThread02 t1 = new TestThread02("https://lmg.jj20.com/up/allimg/4k/s/02/2109242332225H9-0-lp.jpg", "1.jpg");
        TestThread02 t2 = new TestThread02("https://lmg.jj20.com/up/allimg/tp01/1ZZQ20QJS6-0-lp.jpg","2.jpg");
        TestThread02 t3 = new TestThread02("https://lmg.jj20.com/up/allimg/tp04/1Z92G92I25110-0-lp.jpg","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }

    public TestThread02(String url, String name) {
        this.name = name;
        this.url = url;
    }
}


/**
 * 下载器
 */
@Slf4j
class WebDownloader {
    public void downloader(String url, String name) {
        try {
            // commons.io包 下载文件工具包
            // 通过URL下载图片
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("IO异常，downloader方法出现异常！");
        }
    }
}