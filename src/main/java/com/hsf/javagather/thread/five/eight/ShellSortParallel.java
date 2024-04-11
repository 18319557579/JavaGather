package com.hsf.javagather.thread.five.eight;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShellSortParallel {
    public static int[] arr = {89, 9, 10, 67, 6, 20, 1, 2, 5};
//    public static CountDownLatch latch;
    static ExecutorService pool = Executors.newCachedThreadPool();

    public static class ShellSortTask implements Runnable {
        int i= 0;  //本次排序的元素
        int h = 0;  //增量
        CountDownLatch l;

        public ShellSortTask(int i, int h, CountDownLatch latch) {
            this.i = i;
            this.h = h;
            this.l = latch;
        }

        @Override
        public void run() {
            if (arr[i] < arr[i -h]) {
                int tmp = arr[i];
                int j = i - h;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + h] = arr[j];
                    j -= h;
                }
                arr[j + h] = tmp;
            }
            l.countDown();
        }
    }

    public static void pShellSort(int[] arr) throws InterruptedException {
        int h = 1;
        CountDownLatch latch = null;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            System.out.println("h = " + h);
            if (h >= 4) {
                latch = new CountDownLatch(arr.length - h);
            }
            for (int i = h; i < arr.length; i++) {
                if (h >= 4) {
                    pool.execute(new ShellSortTask(i, h, latch));
                } else {
                    if (arr[i] < arr[i -h]) {
                        int tmp = arr[i];
                        int j = i - h;
                        while (j >= 0 && arr[j] > tmp) {
                            arr[j + h] = arr[j];
                            j -= h;
                        }
                        arr[j + h] = tmp;
                    }
                }
            }
            latch.await();
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {89, 9, 10, 67, 6, 20, 1, 2, 5};
        pShellSort(arr);
        System.out.println(Arrays.toString(arr));

        pool.shutdown();
    }
}
