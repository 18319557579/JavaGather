package com.hsf.javagather;

import com.hsf.javautils.LogUtil;
import com.hsf.javautils.regex.RegexUtil;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.hsf.javautils.regex.RegexRecord_Java8.filterContainsNumber;

public class OtherTest {
    public static void main(String[] args) {
        LogUtil.println(
                RegexUtil.findSubstringAll("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})", "#ffbbad #Fc01DF #FFF #ffE").toString()
        );
        LogUtil.println(
                RegexUtil.findSubstringFirst("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})", "#ffbbad #Fc01DF #FFF #ffE")
        );

        LogUtil.println(
                RegexUtil.findSubstringAll("[a-z]\\w{5}", "abc12432", false).toString()
        );
        LogUtil.println(
                RegexUtil.findSubstringAll("[a-z]\\w{5}", "abc12432", true).toString()
        );

        StringBuilder sBuilder = new StringBuilder("abc");
        System.out.println(sBuilder.charAt(0));
        System.out.println(String.valueOf(sBuilder.charAt(0)).equals("a"));


        List<String> list = Arrays.asList("apple", "banana1", "orange2", "grape", "melon3");
        System.out.println("过滤得到包含数字的字符串: " + filterContainsNumber(list));
    }
}
