package com.hsf.javagather.thread.two;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            int i = 0;
            @Override
            public void run() {
                while (i < 1000) {
                    System.out.println("循环: " + i);
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("中断了");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("在sleep时中断了");
//                        Thread.currentThread().interrupt();
                    }
                    i++;
                }
                Thread.yield();
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
