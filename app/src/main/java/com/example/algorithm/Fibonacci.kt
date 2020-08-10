package com.example.algorithm

import java.lang.Exception

fun main() {
    println(fibonacci(5))
    println(fibonacciBest(5))
}

//题目一：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//n<=39
fun fibonacci(n: Int): Int {
    if (n < 0 || n > 39) throw Exception("no a valid num")
    return if (n == 0 || n == 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
}

fun fibonacciBest(n: Int): Int {
    if (n < 0 || n > 39) throw Exception("no a valid num")
    var result = 0
    var tempMinus2 = 0
    var tempMinus1 = 1
    for (i in 2..n) {
        result = tempMinus1 + tempMinus2
        tempMinus2 = tempMinus1
        tempMinus1 = result
    }
    return result
}