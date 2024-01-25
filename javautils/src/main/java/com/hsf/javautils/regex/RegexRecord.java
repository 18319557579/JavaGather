package com.hsf.javautils.regex;

public class RegexRecord {
    /**
     * 判断是否为Ipv4的地址，范围是0.0.0.0~255.255.255.255，要考虑不足三位时前面可能补0的情况
     * 结构：^((…)\.){3}(…)$
     * 0?\d{1,2}代表0 ~ 99，包括前面补0的情况
     * 1\d{2}，匹配 "100" 到 "199"
     * 2[0-4]\d，匹配 "200" 到 "249"
     * 25[0-5]，匹配 "250" 到 "255"
     */
    public static boolean isIpv4(String inputStr) {
        return RegexUtil.matches(
                "^((0?\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])\\.){3}(0?\\d{1,2}|1\\d{2}|2[0-4]\\d|25[0-5])$",
                inputStr);
    }
}
