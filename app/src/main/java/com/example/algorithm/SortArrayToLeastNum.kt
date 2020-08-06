package com.example.algorithm

fun main() {
    val arr = intArrayOf(3, 32, 321, 12331, 45)
    val result = sortToLeast(arr)
    print(result)
}

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
// 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
fun sortToLeast(arr: IntArray): List<Int> {
    return arr.sortedWith(Comparator { p0, p1 ->
        "$p0$p1".compareTo("$p1$p0")
    })
}