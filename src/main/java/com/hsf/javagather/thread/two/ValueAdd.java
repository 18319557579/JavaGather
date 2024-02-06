package com.hsf.javagather.thread.two;

public class ValueAdd implements Runnable{
    static ValueAdd instance = new ValueAdd();
    static volatile int i = 0;

    public static synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ValueAdd());
        Thread t2 = new Thread(new ValueAdd());
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(i);
    }
}
