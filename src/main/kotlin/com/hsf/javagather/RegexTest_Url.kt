package com.hsf.javagather

import com.hsf.javagather.utils.block
import com.hsf.javautils.regex.RegexPackaged
import com.hsf.javautils.regex.RegexRecord
import com.hsf.javautils.url.URLUtil

fun main() {
    block("判断是否为有效url") {
        System.out.println(URLUtil.isValidURL("https://www.example.com"));
        System.out.println(URLUtil.isValidURL("htt://www.example.com"));
        System.out.println(URLUtil.isValidURL("https://www.example.com:8080"));
        System.out.println(URLUtil.isValidURL("https://www.example.com:8080/aaa/bbb"));
        System.out.println(URLUtil.isValidURL("https://www.example.com:8080/aaa/bbb?abc=123"));
        System.out.println(URLUtil.isValidURL("ftp://ftp.example.com"));
        System.out.println(URLUtil.isValidURL("invalid-url"));
        System.out.println(URLUtil.isValidURL("http://localhost:8080"));
        System.out.println(URLUtil.isValidURL("成都大运会.网址"));
    }
}