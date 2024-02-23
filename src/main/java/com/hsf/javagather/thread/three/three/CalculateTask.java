package com.hsf.javagather.thread.three.three;

import java.util.concurrent.*;

public class CalculateTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 49;
    private int start;
    private int end;

    public CalculateTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int result = 0;
            for (int i = start; i <= end; i++) {
                result += i;
            }
            return result;
        } else {
            int middle = (start + end) / 2;
            CalculateTask firstTask = new CalculateTask(start, middle);
            CalculateTask secondTask = new CalculateTask(middle + 1, end);
            invokeAll(firstTask, secondTask);
            return firstTask.join() + secondTask.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start1 = System.currentTimeMillis();
        int result1 = 0;
        for (int i = 1; i <= 1000000; i++) {
            result1 += i;
        }
        System.out.println("循环计算 1-1000000 累加值：" + result1 + ", 时间: " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = pool.submit(new CalculateTask(1, 1000000));
        int result2 = task.get();
        System.out.println("并行计算 1-1000000 累加值：" + result2 + ", 时间: " + (System.currentTimeMillis() - start2));

        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }
}
