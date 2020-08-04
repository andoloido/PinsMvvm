package com.example.algorithm

const val NO_DUPLICATE_NUM = "no duplicated num"
fun main(args: Array<String>) {
    var result = findDuplicateNum(intArrayOf(2, 3, 1, 0, 2, 5, 3))
    println(result)
    result = findDuplicateNoChangeArr(intArrayOf(2, 3, 5, 4, 3, 2, 6, 7))
    println(result)
}

//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
//也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}
//，那么对应的输出是第一个重复的数字2。
fun findDuplicateNum(arr: IntArray): Int {
    val len = arr.size
    if (len == 0) throw Exception(NO_DUPLICATE_NUM)

    for (i in 0 until len) {
        while (arr[i] != i) {
            if (arr[arr[i]] == arr[i]) {
                return arr[i]
            } else {
                val temp = arr[i]
                arr[i] = arr[temp]
                arr[temp] = temp
            }
        }
    }
    throw Exception(NO_DUPLICATE_NUM)
}

//在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。请找出数组中任意一个重复的数字，
//但不能修改输入的数组。例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
fun findDuplicateNoChangeArr(arr: IntArray): Int {
    fun count(arr: IntArray, low: Int, high: Int): Int {
        var count = 0
        for (i in arr.indices) {
            if (arr[i] in low..high) {
                count++
            }
        }
        return count
    }

    val len = arr.size
    if (len <= 1) throw Exception(NO_DUPLICATE_NUM)
    var start = 0
    var end = len - 1
    var mid = 0
    while (start <= end) {
        mid = start + (end - start).shr(1)
        val count = count(arr, start, mid)
        if (count > mid - start + 1) {
            end = mid
        } else {
            start = mid + 1
        }
        if (start == end && count > 1) {
            return start
        }
    }

    throw Exception(NO_DUPLICATE_NUM)
}
