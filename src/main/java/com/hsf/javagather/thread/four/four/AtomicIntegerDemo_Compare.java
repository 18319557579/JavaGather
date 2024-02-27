package com.hsf.javagather.thread.four.four;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo_Compare {
    static int i = 0;
    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 10000; k++) {
                synchronized (AtomicIntegerDemo_Compare.class) {
                    i ++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i + ", 耗时：" + (System.currentTimeMillis() - startTime));

    }
}
