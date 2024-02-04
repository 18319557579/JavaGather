package com.hsf.javagather;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TempJava {
    public static void main(String[] args) {
        /*String inputStr = "";

        Pattern pattern = Pattern.compile("//");
        Matcher matcher = pattern.matcher(inputStr);

        matcher.region()*/

        String text = "Hello, World! This is a test string.";
//        String text = "a9b9c12432";

        // 创建正则表达式模式
        Pattern pattern = Pattern.compile("\\b\\w+\\b");
//        Pattern pattern = Pattern.compile("[a-z]\\w{5}", Pattern.DOTALL);

        // 创建Matcher对象并指定搜索区域
        Matcher matcher = pattern.matcher(text);
//        matcher.region(0, 12); // 从索引0到12的区域搜索

        int startPosition = 0;

        // 执行匹配操作
        while (matcher.find(startPosition)) {
            System.out.println("Match: " + matcher.group());
            System.out.println(matcher.start());
            System.out.println(matcher.end());

            startPosition = matcher.start() + 1;
        }



    }
}
