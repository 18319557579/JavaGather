package com.hsf.javagather

import java.util.regex.Pattern

fun main() {
    /*val pattern = Pattern.compile("123")
    println(pattern.matcher("a123b").matches())

    println(pattern.matcher("a123b").find())

    println(pattern.matcher("a123b").lookingAt())
    println(pattern.matcher("123b").lookingAt())*/

    /*val text = "Line 1\nLine 2\nLine 3"

    // 使用 Pattern.DOTALL 标志匹配整个多行文本
    val pattern = Pattern.compile("Line.*3", Pattern.MULTILINE)

    val matcher: Matcher = pattern.matcher(text)

    while (matcher.find()) {
        System.out.println("匹配的文本：" + matcher.group())
    }*/

    val text = "Li/*ne 1\nLin*/e 2\nLine 3"

    // 使用 Pattern.MULTILINE 标志匹配多行

    // 使用 Pattern.MULTILINE 标志匹配多行
    val pattern = Pattern.compile("/\\*[\\d\\D]*\\*/")

    val matcher = pattern.matcher(text)

    while (matcher.find()) {
        println("匹配的文本：" + matcher.group())
    }
}