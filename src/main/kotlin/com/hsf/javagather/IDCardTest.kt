package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.regex.RegexRecord
import java.util.regex.Pattern

fun main() {
    block("判断是否为有效的身份证号码") {
        val pattern = Pattern.compile("\\d{17}[\\dX]|\\d{15}")
        println(pattern.matcher("440823199903184156").matches())
        println(pattern.matcher("324562").matches())
    }
    block("判断是否为有效的身份证号码（封装）") {
        println(RegexRecord.isLegalIDCard("440823199903184156"))
        println(RegexRecord.isLegalIDCard("345345"))
    }
    block("判断是否为中文词语（封装）") {
        println(RegexRecord.isChineseWords("放"))
        println(RegexRecord.isChineseWords("放撒地方"))
        println(RegexRecord.isChineseWords("445"))
        println(RegexRecord.isChineseWords("放445"))
        println(RegexRecord.isChineseWords("阿斯顿  的"))
    }

}