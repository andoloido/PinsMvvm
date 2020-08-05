package com.example.algorithm

import java.util.*

fun main() {
    val arr =
        intArrayOf(1, 14, 342, 432, 231, 341, 5432, 324, 55463, 5432, 452, 514135, 34164, 314, 231)
    adjustNum(arr)
    print(arr.contentToString())
}

//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
// 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
fun adjustNum(arr: IntArray) {
    val len = arr.size
    var index = 0
    for (i in 0 until len) {
        for (j in len - 1 downTo 1) {
            if (arr[j].and(1) != 0 && arr[j - 1].and(1) == 0) {
                val temp = arr[j]
                arr[j] = arr[j - 1]
                arr[j - 1] = temp
            }
        }
    }
}