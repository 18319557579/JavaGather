package com.hsf.javagather.thread.two;

public class TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.interrupted()) {
                        System.out.println("中断了");
                        break;
                    }
                    System.out.println("我循环了: " + System.currentTimeMillis());
                    Thread.yield();
                }
            }
        };

        t1.start();
        Thread.sleep(1000);
        t1.interrupt();
    }
}
