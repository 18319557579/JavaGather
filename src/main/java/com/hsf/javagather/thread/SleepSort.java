package com.hsf.javagather.thread;

import java.util.Collections;

/**
 * 睡眠排序（闹着玩的）
 */
public class SleepSort {
    public static void sleepSort(int[] numbers) {
        for (int number : numbers) {
            new Thread(() -> {
                try {
                    Thread.sleep(number * 10);  // 数值与睡眠时间的转换因子
                    System.out.println(number);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        sleepSort(numbers);
    }
}

