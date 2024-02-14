package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.LogUtil
import com.hsf.javautils.regex.RegexPackaged
import com.hsf.javautils.regex.RegexRecord
import com.hsf.javautils.regex.RegexUtil

fun main() {
    block("转换时间格式") {
        println(RegexRecord.convertDateFormat("2017-06/12hsf黄绍飞2017/06/12。。下一个时间2022|12|15，上一个不行我来2023-10-31。。、、。。2022.11.29"))
    }
    block("得到规范化后的String") {
        println(RegexRecord.encodedIllegalWords("p orfn黄piaN p片iAn"))
        println(RegexRecord.encodedIllegalWords("黄    片"))
        println(RegexRecord.encodedIllegalWords("黄   " +
                " 片"))
        println(RegexRecord.encodedIllegalWords("P O r n"))
        println(RegexRecord.encodedIllegalWords("P O_r n"))
        println(RegexRecord.encodedIllegalWords("黄 pia N"))
        println(RegexRecord.encodedIllegalWords("HUang片"))
        println(RegexRecord.encodedIllegalWords("p 黄orn"))
        println(RegexRecord.encodedIllegalWords("por片n"))
        println(RegexRecord.encodedIllegalWords("POR黄_片"))
    }
    block("判断是否合法(不包含黄片信息)") {
        println(RegexRecord.isLegalWords("p orfn黄piaN p片iAn"))
        println(RegexRecord.isLegalWords("黄    片"))
        println(RegexRecord.isLegalWords("黄   " +
                " 片"))
        println(RegexRecord.isLegalWords("P O r n"))
        println(RegexRecord.isLegalWords("P O_r n"))
        println(RegexRecord.isLegalWords("黄 pia N"))
        println(RegexRecord.isLegalWords("HUang片"))
        println(RegexRecord.isLegalWords("p 黄orn"))
        println(RegexRecord.isLegalWords("por片n"))
        println(RegexRecord.isLegalWords("POR黄_片"))
    }
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
    block("分割驼峰法的String") {
        System.out.println(RegexPackaged.camelCaseSplit("abcKadPPe").joinToString());
        System.out.println(RegexPackaged.camelCaseSplit("se0BeK").joinToString())
        System.out.println(RegexPackaged.camelCaseSplit("WW73eMoe_32").joinToString())
        System.out.println(RegexPackaged.camelCaseSplit("a_23B_23MHS").joinToString())
        System.out.println(RegexPackaged.camelCaseSplit("W22HeM").joinToString())
    }
    block("判断是否为Ipv4的地址") {
        System.out.println(RegexRecord.isIpv4("100.23.232.090"))
        System.out.println(RegexRecord.isIpv4("03.008.120.249"))
        System.out.println(RegexRecord.isIpv4("256.111.120.222"))
    }
    block("获得子分组中的内容") {
        System.out.println(RegexUtil.getSpecifiedGroup(".{4}(.+)", "JavaScript", 1))
    }
    block("去除重复字符") {
        println("***最终的: " + RegexRecord.compressRepeatCharacter("399黄烧沸的黄。hj黄43就就"))
        println("***最终的: " + RegexRecord.compressRepeatCharacter("哈哈"))
        println("***最终的: " + RegexRecord.compressRepeatCharacter("Sdi  / sdhfi   pod"))
    }
    block("判断密码有效性") {
        println(RegexRecord.passwordValid("ValidPassword1!"))
        println(RegexRecord.passwordValid("InvalidPassword"))
        println(RegexRecord.passwordValid("Another_Valid1"))
        println(RegexRecord.passwordValid("Another_Val id1"))
    }
}