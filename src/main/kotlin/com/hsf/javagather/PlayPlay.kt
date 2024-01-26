package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.regex.RegexUtil
import java.util.regex.Pattern

fun main() {
    val inputStr = "12345"
    val regex = "(\\d{1,3}?)(\\d{1,3})"

    /*val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(inputStr)
    val substringList: MutableList<String> = ArrayList()
    if (matcher.find()) {
        for (i in 0 .. matcher.groupCount()) {
            substringList.add(matcher.group(i))
        }
    }*/

    println(RegexUtil.findGroup(regex, inputStr).joinToString())

    block("判断hello是否匹配") {
        val pattern = Pattern.compile("(?=he)^^he(?=\\w)llo$\\b\\b$")
        val matcher = pattern.matcher("hello")
        println(matcher.matches())
    }
    block("判断是否车牌简称") {
        val pattern = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼]$")
        println(pattern.matcher("京").matches())
        println(pattern.matcher("U").matches())
        println(pattern.matcher("港").matches())

    }
    block("是否和合法地级市") {
        val pattern = Pattern.compile("^[A-Z&&[^IO]]$")
        println(pattern.matcher("O").matches())
        println(pattern.matcher("U").matches())
        println(pattern.matcher("8").matches())
        println(pattern.matcher("UU").matches())
    }
    block("判断序号是否合法") {
        val pattern = Pattern.compile("^[0-9A-Z&&[^IO]]{5,6}$")
        println(pattern.matcher("89Z089").matches())
        println(pattern.matcher("345").matches())
        println(pattern.matcher("345435").matches())
        println(pattern.matcher("ADGEY").matches())
        println(pattern.matcher("SJGJ676").matches())
    }
    block("判断是否为合法大陆车牌，不包含粤的情况") {
        val pattern = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}$")
        println(pattern.matcher("湘ASGJ86").matches())
        println(pattern.matcher("台ASGJ86").matches())
        println(pattern.matcher("湘9SGJ86").matches())
        println(pattern.matcher("湘OSGJ86").matches())
        println(pattern.matcher("湘A342").matches())
        println(pattern.matcher("湘A3423463").matches())
        println(pattern.matcher("湘A34%33").matches())
    }
    block("判断是否为合法大陆车牌，单独粤的情况，且不包含港澳") {
        val pattern = Pattern.compile("^粤[[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}$")
        println(pattern.matcher("粤ASGJ86").matches())
        println(pattern.matcher("粤Z26234").matches())
        println(pattern.matcher("粤A2384港").matches())
    }
    block("单独判断港澳情况") {
        val pattern = Pattern.compile("^粤Z[0-9A-Z&&[^IO]]{4}[港澳]$")
        println(pattern.matcher("粤Z2235港").matches())
        println(pattern.matcher("粤Z2港").matches())
        println(pattern.matcher("粤Z222HD澳").matches())
        println(pattern.matcher("湘A222HD澳").matches())
    }
    block("车牌号总判断") {
        val pattern = Pattern.compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵青藏川宁琼][[A-Z]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|粤([[A-Y]&&[^IO]][0-9A-Z&&[^IO]]{5,6}|Z[0-9A-Z&&[^IO]]{4}[港澳])$")
        println(pattern.matcher("湘ASGJ86").matches())
        println(pattern.matcher("粤Z2235港").matches())
        println(pattern.matcher("粤Z2港").matches())
        println(pattern.matcher("粤Z222HD澳").matches())
        println(pattern.matcher("湘A222HD325").matches())
        println(pattern.matcher("粤Y324L港").matches())
        println(pattern.matcher("粤Z324L港").matches())
    }
}