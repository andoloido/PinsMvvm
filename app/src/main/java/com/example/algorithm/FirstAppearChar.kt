package com.example.algorithm

//题目一：字符串中第一个只出现一次的字符。
//
//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
fun firstAppearChar(arr: CharArray): Int {
    val auxiliaryArr = IntArray(256)
    for (char in arr) {
        auxiliaryArr[char.toInt()]++
    }
    for (char in arr) {
        if (auxiliaryArr[char.toInt()] == 1) {
            return char.toInt()
        }
    }
    return -1
}