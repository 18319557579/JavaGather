package com.hsf.javagather.thread.two;

public class PriorityDemo {

    public static class HighPriority extends Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count ++;
                    if (count > 10000000) {
                        System.out.println("高优先级完成了");
                        break;
                    }
                }
            }
        }
    }

    public static class LowPriority extends Thread {
        static int count = 0;
        @Override
        public void run() {
            while (true) {
                synchronized (PriorityDemo.class) {
                    count ++;
                    if (count > 10000000) {
                        System.out.println("低优先级完成了");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread high = new HighPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
