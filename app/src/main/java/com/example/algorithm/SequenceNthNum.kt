package com.example.algorithm

import kotlin.math.pow

fun main() {
    var result = sequenceNthNum(19)
    println(result)
    result = sequenceNthNum(5)
    println(result)
    result = sequenceNthNum(13)
    println(result)
    result = sequenceNthNum(10)
    println(result)
}

fun sequenceNthNum(index: Int): Int {
    if (index < 0) return -1
    val resultArray = checkDigit(index)
    val digit = resultArray[0]
    val start = resultArray[1]
    val num2 = (index - start - 1) % digit
    val num1 = (index - start - 1) / digit
    val result = start + num1 + 1
    return transfer(result)!![num2]
}

//Int的话这里结果toInt不会有越界问题
fun checkDigit(index: Int): IntArray {
    var result = 1
    var d = 9.0
    var start = 0.0
    while (index > d) {
        start = d
        d += result * 9 * (10.0.pow(result))
        result++
    }
    return intArrayOf(result, start.toInt())
}
