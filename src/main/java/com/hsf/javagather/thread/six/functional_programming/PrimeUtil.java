package com.hsf.javagather.thread.six.functional_programming;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class PrimeUtil {
    public static boolean isPrime(int number) {
        int tmp = number;
        if (tmp < 2) {
            return false;
        }
        for (int i = 2; Math.sqrt(tmp) >= i; i++) {
            if (tmp % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        long result = IntStream.range(1, 1000000).filter(PrimeUtil::isPrime).count();
        System.out.println(result);

        int[] arr = new int[1000];
        Arrays.sort(arr);
        Arrays.parallelSort(arr);

        Random random = new Random();
        Arrays.setAll(arr, (i) -> random.nextInt());
        Arrays.parallelSetAll(arr, i -> random.nextInt());




    }
}
