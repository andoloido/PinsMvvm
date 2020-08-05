package com.example.algorithm

fun main() {
    print(findOverHalf(intArrayOf(1,2,3,2,2,2,5,4,2)))
}
//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
// 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
fun findOverHalf(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    var result = arr[0]
    var count = 1
    for (i in 1 until arr.size) {
        if (arr[i] == result) {
            count++
        } else {
            count--
            if (count == 0) {
                result = arr[i]
                count++
            }
        }
    }
    count = 0
    for (num in arr) {
        if (num == result) count++
    }
    return if (count > arr.size / 2) result else 0
}