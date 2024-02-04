package com.hsf.javagather

import org.json.JSONArray
import org.json.JSONObject

fun main() {
    val jsonObj = JSONObject()
    jsonObj.put("page", "pagefirst")
    jsonObj.put("code", 6)

    val jsonObjInner = JSONObject()
    jsonObjInner.put("weight", 50.5)

    val jsonArrayInner = JSONArray()
    jsonArrayInner.put("hsf")
    val jsonArrayInnerObj = JSONObject()
    jsonArrayInnerObj.put("name", "hwt")
    jsonArrayInnerObj.put("nickname", JSONObject.NULL)
    jsonArrayInner.put(jsonArrayInnerObj)

    jsonObjInner.put("person", jsonArrayInner)

    jsonObj.put("data", jsonObjInner)

    println(jsonObj.toString())
}