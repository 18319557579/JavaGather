package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.LogUtil
import com.hsf.javautils.regex.RegexRecord
import com.hsf.javautils.regex.RegexUtil
import java.util.regex.Pattern

fun main() {
    block("测试邮箱合法性") {
        val pattern = Pattern.compile("^[0-9a-zA-Z]+@[0-9a-zA-Z]+(\\.[0-9a-zA-Z]+)+$")
        println( pattern.matcher("001Abc@lenovo.com.cn").matches())
        println( pattern.matcher("001Ab_c@lenovo.com.cn").matches())
        println( pattern.matcher("5@lenovo.com.cn").matches())
        println( pattern.matcher("5@lenovo").matches())
        println( pattern.matcher("001Abc@lenovo.com.cn,dsf").matches())
        println( pattern.matcher("001Abc@@lenovo.com.cn").matches())
        println( pattern.matcher("5@5.5").matches())
    }
    block("测试邮箱合法性，用封装的") {
        println( RegexRecord.isLegalEmail("001Abc@lenovo.com.cn"))
        println( RegexRecord.isLegalEmail("001Ab_c@lenovo.com.cn"))
        println( RegexRecord.isLegalEmail("5@lenovo.com.cn"))
        println( RegexRecord.isLegalEmail("5@lenovo"))
        println( RegexRecord.isLegalEmail("001Abc@lenovo.com.cn,dsf"))
        println( RegexRecord.isLegalEmail("001Abc@@lenovo.com.cn"))
        println( RegexRecord.isLegalEmail("5@5.5"))

    }

}