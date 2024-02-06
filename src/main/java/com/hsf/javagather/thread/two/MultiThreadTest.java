package com.hsf.javagather.thread.two;

public class MultiThreadTest {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(t1.getState());

        t1.start();
        System.out.println(t1.getState());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t1.getState());
    }
}
