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

    /**
     * 判断是否为中国合法的车牌号
     * 1.首位为省级单位的简称，包括31个: 京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼
     * 2.接着为地级市的代号，常规为A-Z，但是不能为字母I或O
     * 3.接着为车牌的序号，为5-6位的数字0-9或大写字母A-Z，但是不能为字母I或O
     * 4.港澳地区的比较特殊，必须为粤Z开头，结尾为港/澳，中间剩下的序号仅有4位了
     *
     * 因此先考虑非粤的情况，即 [京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}
     * 在粤的情况中，分为非港澳，即 粤[[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}
     * 港澳，即 粤Z[0-9A-Z&&[^IO]]{4}[港澳]
     */
    public static boolean isLegalCarNum(String inputStr) {
        return RegexUtil.matches(
                "^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|粤([[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|Z[0-9A-Z&&[^IO]]{4}[港澳])$",
                inputStr);
    }
}
