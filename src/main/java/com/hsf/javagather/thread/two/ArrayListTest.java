package com.hsf.javagather.thread.two;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListTest {
    static Vector<Integer> al = new Vector<>(10);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
