package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.regex.RegexRecord_Java8

fun main() {
    block("将字符串以空白符进行分割，再得到长度不少于4的元素") {
        println(RegexRecord_Java8.getLengthGreaterThan4Element("hello there how are you doing today"))
        println(RegexRecord_Java8.getLengthGreaterThan4Element("hello 2342342 舒服  ++&W$"))
    }
}