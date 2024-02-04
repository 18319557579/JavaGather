package com.hsf.javagather

import com.hsf.javautils.number_format.NumberFormatUtil

fun main() {
    println("-------------------------将数字保留两位小数-------------------------")
    println(NumberFormatUtil.keepTwoDecimals(53.234F))
    println(NumberFormatUtil.keepTwoDecimals(53.364F))
    println(NumberFormatUtil.keepTwoDecimals(53F))
}