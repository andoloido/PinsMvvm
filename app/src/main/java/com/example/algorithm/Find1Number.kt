package com.example.algorithm

fun main() {
    print(find1Number(5))
}

//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
fun find1Number(n: Int): Int {
    var temp = n
    var count = 0
    while (temp != 0) {
        if (temp.and(1) == 1) {
            count++
        }
        temp = temp.ushr(1)
    }
    return count
}