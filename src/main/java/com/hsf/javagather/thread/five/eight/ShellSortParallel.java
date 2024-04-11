package com.hsf.javagather.thread.five.eight;

import java.util.concurrent.CountDownLatch;

public class ShellSortParallel {
    public static int[] arr;

    public static class ShellSortTask implements Runnable {
        int i= 0;
        int h = 0;
        CountDownLatch latch;

        public ShellSortTask(int i, int h, CountDownLatch latch) {
            this.i = i;
            this.h = h;
            this.latch = latch;
        }

        @Override
        public void run() {
            if (arr[i] < arr[i -h]) {
                int tmp = arr[i];
            }
        }
    }
}
