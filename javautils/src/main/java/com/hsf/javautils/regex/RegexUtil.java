package com.hsf.javautils.regex;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    /**
     * 判断输入串inputStr，是否完全和regex匹配
     */
    public static boolean matches(String regex, String inputStr) {
        return Pattern.compile(regex).matcher(inputStr).matches();
    }

    /**
     * 判断输入串inputStr中，是否存在和regex匹配的子串
     */
    public static boolean find(String regex, String inputStr) {
        return Pattern.compile(regex).matcher(inputStr).find();
    }

    /**
     * 输入串inputStr中，找到第一个和regex匹配的子串
     */
    public static String findSubstringFirst(String regex, String inputStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.find()) {
            //todo 这种方式是不是会存在bug，尝试找出反例
            return matcher.group();
        }
        return null;
    }

    /**
     * 输入串inputStr中，找到所有和regex匹配的子串
     */
    public static List<String> findSubstringAll(String regex, String inputStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        List<String> substringList = new ArrayList<>();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String match = inputStr.substring(start, end);
            substringList.add(match);
        }
        return substringList;
    }

    /**
     * 输入串inputStr中，找到所有和regex匹配的子串的位置
     */
    public static List<Integer> findAllLocation(String regex, String inputStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        List<Integer> matchPosition = new ArrayList<>();
        while (matcher.find()) {
            int start = matcher.start();
            matchPosition.add(start);
        }
        return matchPosition;
    }

    /**
     *  输入串inputStr中，找到所有和模式regex匹配的子串(包括字符串/位置)，替换为指定的内容replacement
     */
    public static String replaceAll(String regex, String inputStr, String replacement) {
        return Pattern.compile(regex).matcher(inputStr).replaceAll(replacement);
    }

    /**
     * 输入串inputStr中，找到第一个和模式regex匹配的子串(包括字符串/位置)，替换为指定的内容replacement
     */
    public static String replaceFirst(String regex, String inputStr, String replacement) {
        return Pattern.compile(regex).matcher(inputStr).replaceFirst(replacement);
    }

    /**
     * 输入串inputStr中，找到所有匹配的分组内容，包括group0
     */
    public static List<String> findGroup(String regex, String inputStr) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        List<String> substringList = new ArrayList<>();
        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                substringList.add(matcher.group(i));
            }
        }
        return substringList;
    }
}
