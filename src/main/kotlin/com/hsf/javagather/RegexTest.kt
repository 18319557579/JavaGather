package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.LogUtil
import com.hsf.javautils.regex.RegexPackaged
import com.hsf.javautils.regex.RegexUtil

fun main() {
    block("测试正则表达式globalFind()和singleFind()") {
        LogUtil.println(
            RegexUtil.findSubstringAll("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})", "#ffbbad #Fc01DF #FFF #ffE").toString()
        )
        LogUtil.println(
            RegexUtil.findSubstringFirst("#([0-9a-fA-F]{6}|[0-9a-fA-F]{3})", "#ffbbad #Fc01DF #FFF #ffE")
        )
    }
    block("判断是否为windows路径") {
        System.out.println(RegexPackaged.isWindowsDir("F:\\study\\javascript\\regex\\regular expression.pdf"));
        System.out.println(RegexPackaged.isWindowsDir("F:\\study\\javascript\\regex\\"));
        System.out.println(RegexPackaged.isWindowsDir("F:\\study\\javascript"));
        System.out.println(RegexPackaged.isWindowsDir("F:\\"));
        System.out.println(RegexPackaged.isWindowsDir("F:\\sdf\\*3"));
    }

}