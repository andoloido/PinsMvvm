package com.example.algorithm

//题目：输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
fun maxSubArray(arr: IntArray): Int {
    var max = Int.MIN_VALUE
    var sum = 0
    for (num in arr) {
        if (sum + num < 0) {
            sum = 0
        } else {
            sum += num
        }
        if (sum > max) {
            max = sum
        }
    }
    return max
}

fun main() {
    print(maxSubArray(intArrayOf(1, -2, 3, 10, -4, 7, 2, -5)))
}