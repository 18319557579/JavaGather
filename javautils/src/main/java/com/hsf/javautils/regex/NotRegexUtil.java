package com.hsf.javautils.regex;

import java.util.HashSet;
import java.util.Set;

public class NotRegexUtil {
    /**
     * 判断是否为有效的双色球号码
     */
    public static boolean isValidDoubleColorBall(Integer[] numbers) {
        if (numbers == null || numbers.length != 7) {
            return false;
        }

        Set<Integer> redNumbers = new HashSet<>();

        // 判断红色球的号码
        for (int i = 0; i < 6; i++) {
            int num = numbers[i];
            if (num < 1 || num > 33 || redNumbers.contains(num)) {
                return false; // 确保在1到33之间且不重复
            }
            redNumbers.add(num);
        }

        // 判断蓝色球的号码
        int blueNum = numbers[6];
        if (blueNum < 1 || blueNum > 16) {
            return false; // 确保在1到16之间
        }

        return true;
    }

}
