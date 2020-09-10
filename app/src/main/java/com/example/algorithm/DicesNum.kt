package com.example.algorithm

import kotlin.math.pow

fun main() {
    allPropertyByThrowNDices(6)
}
//题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
fun allPropertyByThrowNDices(n: Int) {
    val maxValue = 6
    val auxiliaryArray = Array(2) { IntArray(maxValue * n + 1) }
    for (i in 1..maxValue) {
        auxiliaryArray[0][i] = 1
    }
    var flag = 0
    for (i in 2..n) {
        for (t in 0..i) {
            auxiliaryArray[1 - flag][t] = 0
        }
        for (k in i..(maxValue * i)) {
            for (j in 1..maxValue) {
                if (j > k) continue
                auxiliaryArray[1 - flag][k] += auxiliaryArray[flag][k - j]
            }
        }
        flag = 1 - flag
    }
    val total = maxValue.toDouble().pow(n.toDouble())
    for (i in n..(maxValue * n)) {
        println("$i:${auxiliaryArray[flag][i]}")
    }
}