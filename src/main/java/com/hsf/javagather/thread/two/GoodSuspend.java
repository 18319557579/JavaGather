package com.hsf.javagather.thread.two;

public class GoodSuspend {
    public static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        volatile boolean suspendme = false;
        public void suspendMe() {
            suspendme = true;
        }

        public void resumeMe() {
            suspendme = false;
            synchronized (this) {
                notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (suspendme) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (u) {
                    System.out.println("in ChangeObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {

    }
}
