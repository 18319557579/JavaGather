package com.hsf.javagather;

import com.hsf.javautils.LogUtil;
import com.hsf.javautils.regex.RegexUtil;

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

    }
}
