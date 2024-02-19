package com.hsf.javagather.thread.three;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable{
    public ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            } finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_1");
        Thread t2 = new Thread(r1, "Thread_2");
        t1.start();
        t2.start();
    }
}
