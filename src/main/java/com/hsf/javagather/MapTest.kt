package com.hsf.javagather

import com.hsf.javautils.LogUtil
import com.hsf.javautils.map.MapUtil

fun main(args: Array<String>) {
    val myMap: MutableMap<Float, String> = HashMap()
    myMap[0.1f] = "hsf"
    myMap[0.2f] = "hwt"
    myMap[0.3f] = "hqs"
    LogUtil.println("找到的KEY：" + MapUtil.getKey(myMap, "hsf"))
}