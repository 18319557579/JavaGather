package com.hsf.javagather

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

}