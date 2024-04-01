package com.hsf.javagather.thread.five.eight;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 奇偶交换排序，使用多线程进行优化
 */
public class ParallelSortOptimizeDemo {
    static int exchFlag = 1;
    static ExecutorService pool = Executors.newCachedThreadPool();
//    static int[] arr = {5, 52, 6, 3, 4, 6};

    static synchronized void setExchFlag(int v) {
        exchFlag = v;
    }
    static synchronized int getExchFlag() {
        return exchFlag;
    }

    public static class OddEvenSortTask implements Runnable {
        int i;
        CountDownLatch latch;
        int[] arr;

        public OddEvenSortTask(int i, CountDownLatch latch, int[] arr) {
            this.i = i;
            this.latch = latch;
            this.arr = arr;
        }

        @Override
        public void run() {
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                setExchFlag(1);
            }
            latch.countDown();
        }
    }

    public static void pOddEvenSort(int[] arr) throws InterruptedException {
        int start = 0;
        while (getExchFlag() == 1 || start == 1) {
            setExchFlag(0);
            CountDownLatch latch = new CountDownLatch((arr.length - start) / 2);
            for (int i = start; i < arr.length - 1; i += 2) {
                pool.submit(new OddEvenSortTask(i, latch, arr));
            }
            latch.await();
            if (start == 0)
                start = 1;
            else
                start = 0;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] unordered = {5, 52, 6, 3, 4, 6, -1};
        pOddEvenSort(unordered);

        pool.shutdown();

        for (int num : unordered) {
            System.out.printf("%d ", num);
        }
    }
}
