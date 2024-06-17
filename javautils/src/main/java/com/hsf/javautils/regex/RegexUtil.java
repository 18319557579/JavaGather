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
    /**
     * 第一
     * {@link com.hsf.javautils.regex.RegexUtil#matches}
     * 第二
     * @see com.hsf.javautils.regex.RegexUtil#matches
     * @param regex
     * @param inputStr
     * @return
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

    public static List<String> findSubstringAll(String regex, String inputStr) {
        return findSubstringAll(regex, inputStr, false);
    }

    /**
     * 输入串inputStr中，找到所有和regex匹配的子串
     *
     * Matcher.find() 方法默认是从当前匹配的子序列的结束位置（通过 end() 获取）之后的位置开始匹配下一个子序列。
     * 如果你希望回溯匹配，可以使用 Matcher.find(int start) 方法来指定从哪个位置开始查找下一个匹配
     * @param allowBacktracking 是否启用find()回溯匹配
     */
    public static List<String> findSubstringAll(String regex, String inputStr, boolean allowBacktracking) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        List<String> substringList = new ArrayList<>();

        if (allowBacktracking) {
            int startPosition = 0;
            while (matcher.find(startPosition)) {
                substringList.add(matcher.group());

                startPosition = matcher.start() + 1;
            }

        } else {
            while (matcher.find()) {
                substringList.add(matcher.group());
            }
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

    /**
     * 获得指定指定分组的匹配内容，注意0代表整体匹配。所以子分组从1开始
     */
    public static String getSpecifiedGroup(String regex, String inputStr, int groupIndex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.find()) {
            return matcher.group(groupIndex);
        }
        return null;
    }

    /**
     * 将输入串用正则进行分割
     */
    public static String[] splitInputString(String regex, String inputStr) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.split(inputStr);
    }
}
