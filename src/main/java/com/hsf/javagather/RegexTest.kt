package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.LogUtil
import com.hsf.javautils.regex.RegexPackaged
import com.hsf.javautils.regex.RegexRecord
import com.hsf.javautils.regex.RegexRecord_Java8
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
    block("判断密码有效性2") {
        println(RegexRecord.passwordValid2("abAB12_!"))
        println(RegexRecord.passwordValid2("bAB12_!!"))
        println(RegexRecord.passwordValid2("abcdA12_!"))
        println(RegexRecord.passwordValid2("adsfabAB1_!"))
        println(RegexRecord.passwordValid2("abASDFSB12!"))
        println(RegexRecord.passwordValid2("abABsfaffeafsadfsfsfasdfsadf12_!"))
    }
    block("获得密码的安全等级") {
        println(RegexRecord.passwordSecurityLevel("12sdf!"))
        println(RegexRecord.passwordSecurityLevel("12sf!"))
        println(RegexRecord.passwordSecurityLevel(" 1232sf!"))
        println(RegexRecord.passwordSecurityLevel("和你1232sf!"))
        println(RegexRecord.passwordSecurityLevel("12sdf!rwerwwqqe"))
        println(RegexRecord.passwordSecurityLevel("12sdf!rwerwwqqe*"))
        println(RegexRecord.passwordSecurityLevel("12sqe!!*"))
        println(RegexRecord.passwordSecurityLevel("12sasdfasfasfasfas343453151355234325fasfqe!!*"))
    }
    block("判断是否匹配复杂的正则") {
        println(RegexRecord.isComplexString("a123.xyz789"))
        println(RegexRecord.isComplexString("1.abc123"))
        println(RegexRecord.isComplexString("abc.sdfsf23"))
        println(RegexRecord.isComplexString("zna32,.*fssafsd3"))
        println(RegexRecord.isComplexString("ppPPP33274832.,.UE33223"))
        println(RegexRecord.isComplexString("UI23234.,.,.,jff33333f\ne"))
        println(RegexRecord.isComplexString("UI23234.,.,.,jff33333f\ne2"))
    }
    block("过滤得到包含数字的字符串") {
        val strs = mutableListOf("apple", "banana1", "orange2", "grape", "melon3")
        println("过滤得到包含数字的字符串：" + RegexRecord_Java8.filterContainsNumber(strs))
    }
    block("判断是否为合法的Java数值（十进制）") {
        println(RegexRecord.isJavaNumericTypes("349349000"))
        println(RegexRecord.isJavaNumericTypes("349349000l"))
        println(RegexRecord.isJavaNumericTypes("349349000L"))
        println(RegexRecord.isJavaNumericTypes("349349000Ll"))
        println(RegexRecord.isJavaNumericTypes("3_4___934___900__0l"))
        println(RegexRecord.isJavaNumericTypes("_3_4___934___900__0l"))
        println(RegexRecord.isJavaNumericTypes("0"))
        println(RegexRecord.isJavaNumericTypes("0L"))
        println(RegexRecord.isJavaNumericTypes("0_"))
        println(RegexRecord.isJavaNumericTypes("_0"))
    }
    block("判断是否为合法的Java数值（八进制）") {
        println(RegexRecord.isJavaNumericTypes("00"))
        println(RegexRecord.isJavaNumericTypes("0000L"))
        println(RegexRecord.isJavaNumericTypes("0000Ll"))
        println(RegexRecord.isJavaNumericTypes("0738"))
        println(RegexRecord.isJavaNumericTypes("023__3"))
        println(RegexRecord.isJavaNumericTypes("0_23__3"))
        println(RegexRecord.isJavaNumericTypes("0____23__3"))
        println(RegexRecord.isJavaNumericTypes("0_0"))
        println(RegexRecord.isJavaNumericTypes("0_L"))
        println(RegexRecord.isJavaNumericTypes("0_0000033L"))
    }
    block("判断是否为合法的Java数值（十六进制）") {
        println(RegexRecord.isJavaNumericTypes("0x00"))
        println(RegexRecord.isJavaNumericTypes("0x00L"))
        println(RegexRecord.isJavaNumericTypes("0X"))
        println(RegexRecord.isJavaNumericTypes("0xL"))
        println(RegexRecord.isJavaNumericTypes("0X__L"))
        println(RegexRecord.isJavaNumericTypes("0x73KL"))
        println(RegexRecord.isJavaNumericTypes("0X73_3429_A_CCDbcL"))
        println(RegexRecord.isJavaNumericTypes("00x89"))
        println(RegexRecord.isJavaNumericTypes("0x_7328"))
        println(RegexRecord.isJavaNumericTypes("0x000834_324_3454_00L"))
    }
    block("判断是否为合法的Java数值（二进制）") {
        println(RegexRecord.isJavaNumericTypes("0b001"))
        println(RegexRecord.isJavaNumericTypes("0bb0110"))
        println(RegexRecord.isJavaNumericTypes("0bL"))
        println(RegexRecord.isJavaNumericTypes("0b111_0L"))
        println(RegexRecord.isJavaNumericTypes("0b111_L"))
        println(RegexRecord.isJavaNumericTypes("0B_101"))
        println(RegexRecord.isJavaNumericTypes("0b0201L"))
        println(RegexRecord.isJavaNumericTypes("0b0b"))
        println(RegexRecord.isJavaNumericTypes("0b1_0_____0____1___1L"))
        println(RegexRecord.isJavaNumericTypes("0b00000000000000000000"))
    }
    block("判断是否为合法的Java数值（float）") {
        println(RegexRecord.isJavaNumericTypes("0f"))
        println(RegexRecord.isJavaNumericTypes("0.0f"))
        println(RegexRecord.isJavaNumericTypes("0.f"))
        println(RegexRecord.isJavaNumericTypes(".0f"))
        println(RegexRecord.isJavaNumericTypes("00000000.03f"))
        println(RegexRecord.isJavaNumericTypes("0005800.05f"))
        println(RegexRecord.isJavaNumericTypes("78.0500000f"))
        println(RegexRecord.isJavaNumericTypes("0.2340240f"))
        println("*******************************************")
        println(RegexRecord.isJavaNumericTypes("0_____00_000__00.0_3f"))
        println(RegexRecord.isJavaNumericTypes("0_005_800.0_5f"))
        println(RegexRecord.isJavaNumericTypes("7_8.0500000f"))
        println(RegexRecord.isJavaNumericTypes("0.23_402_4_0f"))
        println(RegexRecord.isJavaNumericTypes("073_.8f"))
        println(RegexRecord.isJavaNumericTypes("073._8f"))
        println(RegexRecord.isJavaNumericTypes("_073.8f"))
        println(RegexRecord.isJavaNumericTypes("073.8_f"))
        println(RegexRecord.isJavaNumericTypes("073.8f_"))
    }
    block("判断是否为合法的Java数值（double）") {
        println(RegexRecord.isJavaNumericTypes("0"))
        println(RegexRecord.isJavaNumericTypes("0.0D"))
        println(RegexRecord.isJavaNumericTypes("0.L"))
        println(RegexRecord.isJavaNumericTypes(".0"))
        println(RegexRecord.isJavaNumericTypes("00000000.03D"))
        println(RegexRecord.isJavaNumericTypes("0005800.05d"))
        println(RegexRecord.isJavaNumericTypes("78.0500000"))
        println(RegexRecord.isJavaNumericTypes("0.2340240dD"))
        println("*******************************************")
        println(RegexRecord.isJavaNumericTypes("-0_____00_000__00.0_3"))
        println(RegexRecord.isJavaNumericTypes("-0_005_800.0_5dD"))
        println(RegexRecord.isJavaNumericTypes("-7_8.0500000d"))
        println(RegexRecord.isJavaNumericTypes("-0.23_402_4_0"))
        println(RegexRecord.isJavaNumericTypes("-073_.8D"))
        println(RegexRecord.isJavaNumericTypes("-073._8D"))
        println(RegexRecord.isJavaNumericTypes("-_073.8"))
        println(RegexRecord.isJavaNumericTypes("-073.8_dD"))
        println(RegexRecord.isJavaNumericTypes("-073.8d_"))
    }
    block("判断是否为合法的Java数值（科学计数法）") {
        println(RegexRecord.isJavaNumericTypes("1.2_003E4"));
        println(RegexRecord.isJavaNumericTypes("5.6__7e-3"));
        println(RegexRecord.isJavaNumericTypes("5.6__7e-_1_3"));
        println(RegexRecord.isJavaNumericTypes("-6____0.6__61___5e00"));
        println(RegexRecord.isJavaNumericTypes("1.2_003E1.4"));
        println(RegexRecord.isJavaNumericTypes("1.2_003_E04"));
        println(RegexRecord.isJavaNumericTypes("1.2_003E_04"));
        println(RegexRecord.isJavaNumericTypes("1.2_003E"));
        println(RegexRecord.isJavaNumericTypes("1.2_003E001D"));
    }
    block("是否为美国电话号码") {
        println(RegexRecord.isAmericanPhoneNumber("(000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("0001234567"))
        println(RegexRecord.isAmericanPhoneNumber("(0001234567"))
        println(RegexRecord.isAmericanPhoneNumber("000)1234567"))

        println(RegexRecord.isAmericanPhoneNumber("(000) 1234567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)-1234567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)_1234567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)  1234567"))

        println(RegexRecord.isAmericanPhoneNumber("(000)123 4567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)123-4567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)12304567"))
        println(RegexRecord.isAmericanPhoneNumber("(000)123  4567"))

        println("专门研究前面的+1  -----------")
        println(RegexRecord.isAmericanPhoneNumber("+1(000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("+1 (000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("1(000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("1 (000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber(" (000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("+ (000)1234567"))
        println(RegexRecord.isAmericanPhoneNumber("2221234567"))
        println(RegexRecord.isAmericanPhoneNumber("1111234567"))
    }
    block("重命名文件名") {
        println(RegexRecord.getNewFileName("aaa"))
        println(RegexRecord.getNewFileName("aaa.apk"))
        println(RegexRecord.getNewFileName("aaa.bb.c.apk"))
    }
    block("去掉后缀名，只获得文件名") {
        println(RegexPackaged.getFileName("aaa"))
        println(RegexPackaged.getFileName("aaa."))
        println(RegexPackaged.getFileName("aaa.apk"))
        println(RegexPackaged.getFileName("aaa.apk."))
        println(RegexPackaged.getFileName("aaa.bb.c.apk"))
        println(RegexPackaged.getFileName("aaa.bb.c.apk."))
    }
    block("找到美元，都加10") {
        println(RegexRecord.add2("The price is $10 hello"))
        println(RegexRecord.add2("The price is #23 hello"))
    }
    block("找到最里层的书名") {
        println(RegexRecord.getInnermostTitle("上午传达了《镇政府关于落实县政府〈关于落实省政府《关于棉花收购的通知》〉》。"))
        println(RegexRecord.getInnermostTitle("我有一本《读〈地球〉和〈月球〉有感》在家里"))
        println(RegexRecord.getInnermostTitle("《读〈石钟山记〉有感》"))
        println(RegexRecord.getInnermostTitle("《〈中国工人〉发刊词》发表于1940年2月7日，记载在《词集》中"))
    }
}