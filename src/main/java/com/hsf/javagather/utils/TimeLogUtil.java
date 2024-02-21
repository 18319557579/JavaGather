package com.hsf.javagather.utils;

public class TimeLogUtil {
    public static void out(String content) {
        System.out.println(System.currentTimeMillis() / 1000 + " --- " + content);
    }
}
