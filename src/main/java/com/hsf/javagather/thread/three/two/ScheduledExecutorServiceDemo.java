package com.hsf.javagather.thread.three.two;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
    volatile static int i = 0;

    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        System.out.println("启动时司时间： " + System.currentTimeMillis() / 1000);
        ses.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    /*if (i == 0) {
                        Thread.sleep(8000);
                        i++;
                    } else {
                        Thread.sleep(1000);
                    }*/
                    Thread.sleep(1000);
                    System.out.println(System.currentTimeMillis() / 1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, TimeUnit.SECONDS);

    }
}
