package com.example.algorithm

import kotlin.math.pow


fun main() {
    println(findOneAppearFrequency(11))
}

//题目：输入一个整数n，求1 ~ n这n个整数的十进制表示中1出现的次数。例如，输入12，1 ~ 12这些整数中包含1的数字有1、10、11和12，1一共出现了5次。
fun findOneAppearFrequency(num: Int): Double {
    var frequency = 0.0
    if (num < 1) return frequency
    val array = transfer(num)
    for (i in array!!.indices) {
        frequency += array[i] * calculateMaxOneNum(array.size - i - 1)
        if (array[i] > 1) frequency += 10.0.pow(array.size - i - 1) else {
            if (array[i] == 0) continue
            if (array[i] == 1) {
                var tempTotal = 0
                var temp = i + 1
                while (temp < array.size ) {
                    tempTotal = tempTotal * 10 + array[temp]
                    temp++
                }
                tempTotal++
                frequency += tempTotal
            }
        }
    }
    return frequency
}

fun calculateMaxOneNum(digit: Int): Double {
    if (digit < 1) return 0.0
    if (digit == 1) return 1.0
    var total = 1.0
    var exp = 1.0
    var temp = digit
    while (temp > 1) {
        total += (total * 9 + 10.0.pow(exp))
        exp++
        temp--
    }
    return total
}

fun transfer(a: Int): IntArray? {
    var str: String? = null
    str = Integer.toString(a)
    val arr = IntArray(str.length)
    for (i in arr.indices) {
        val c = str[i]
        val s = c.toString()
        val num = s.toInt()
        arr[i] = num
    }
    return arr
}