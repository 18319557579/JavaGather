package com.hsf.javagather.thread.five.five.jdk_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(future);

        System.out.println("请求完毕");

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {

        }

        System.out.println("数据 = " + future.get());

        executorService.shutdown();
    }
}
