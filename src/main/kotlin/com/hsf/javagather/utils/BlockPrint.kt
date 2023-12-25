package com.hsf.javagather.utils

fun block(title: String, func: () -> Unit) {
    println("------------------------------$title------------------------------")
    func()
    println()
}