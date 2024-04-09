package com.hsf.javagather.thread.five.eight;

import java.util.Arrays;

public class ShellSort {
    /**
     * 希尔排序
     * 使用Knuth增量序列
     * 递归公式为: n = n + 1
     * 通项公式为: (3 ^ k - 1) / 2
     */
    public static void shellSort(int[] arr) {
        //先计算出最大的h值，后面再按规律逐渐减小
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
            System.out.println("h的值: " + h);
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                if (arr[i] < arr[i -h]) {
                    int tmp = arr[i];  //待插入元素
                    int j = i - h;
                    while (j >= 0 && arr[j] > tmp) {
                        arr[j + h] = arr[j];
                        j -= h;
                    }
                    arr[j + h] = tmp;
                }
            }
            h = (h - 1) / 3;  //这一轮的排序搞定了，减小增量，下一轮排序
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 10, 67, 89, 20, 1, 2};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
