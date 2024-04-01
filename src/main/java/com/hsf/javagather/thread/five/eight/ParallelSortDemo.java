package com.hsf.javagather.thread.five.eight;

/**
 * 奇偶交换排序
 */
public class ParallelSortDemo {
    public static void main(String[] args) {
        int[] unordered = {5, 52, 6, 3, 4, 6};
        oddEvenSort(unordered);

        for (int num : unordered) {
            System.out.printf("%d ", num);
        }
    }

    public static void oddEvenSort(int[] aar) {
        int exchFlag = 1, start = 0;
        while (exchFlag == 1 || start == 1) {
            exchFlag = 0;
            for (int i = start; i < aar.length - 1; i += 2) {
                if (aar[i] > aar[i + 1]) {
                    int temp = aar[i];
                    aar[i] = aar[i + 1];
                    aar[i + 1] = temp;
                    exchFlag = 1;
                }
            }
            if (start == 0)
                start = 1;
            else
                start = 0;
        }
    }
}
