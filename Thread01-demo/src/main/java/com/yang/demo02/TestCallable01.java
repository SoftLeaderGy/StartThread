package com.yang.demo02;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable01 implements Callable<Boolean> {
    public TestCallable01(String url, String name) {
        this.url = url;
        this.name = name;
    }

    private String url;
    private String name;
    @Override
    public Boolean call() throws Exception {

        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载文件完成，文件名为--"+ name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable01 c1 = new TestCallable01("https://lmg.jj20.com/up/allimg/4k/s/02/2109242332225H9-0-lp.jpg", "1.jpg");
        TestCallable01 c2 = new TestCallable01("https://lmg.jj20.com/up/allimg/tp01/1ZZQ20QJS6-0-lp.jpg","2.jpg");
        TestCallable01 c3 = new TestCallable01("https://lmg.jj20.com/up/allimg/tp04/1Z92G92I25110-0-lp.jpg","3.jpg");

        // 创建服务 Executors.newFixedThreadPool(3); 创建线程数为3个
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交执行任务
        Future<Boolean> s1 = executorService.submit(c1);
        Future<Boolean> s2 = executorService.submit(c2);
        Future<Boolean> s3 = executorService.submit(c3);

        // 获取执行线程返回结果
        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());

        // 关闭服务
        executorService.shutdownNow();
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