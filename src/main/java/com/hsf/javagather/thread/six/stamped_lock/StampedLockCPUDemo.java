package com.hsf.javagather.thread.six.stamped_lock;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

public class StampedLockCPUDemo {
    static Thread[] holdCpuThreads = new Thread[3];
    static final StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            Long readLong = lock.writeLock();
            //由于写锁的存在，所有读锁都会被挂起
            LockSupport.parkNanos(600000000000L);
            lock.unlockWrite(readLong);
            System.out.println("已经释放写锁");
        }).start();

        Thread.sleep(100);
        for (int i = 0; i < 3; ++i) {
            holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
            holdCpuThreads[i].start();
        }

        System.out.println("线程都已开启");
        Thread.sleep(10000);
        for (int i = 0; i < 3; ++i) {
            holdCpuThreads[i].interrupt();
        }

    }

    private static class HoldCPUReadThread implements Runnable {
        @Override
        public void run() {
            //使用的是Unsafe.park()函数，而park()函数在遇到线程中断时，会直接返回
            long lockr = lock.readLock();
            System.out.println(Thread.currentThread().getName() + " 获得读锁");
            lock.unlockRead(lockr);
        }
    }
}
