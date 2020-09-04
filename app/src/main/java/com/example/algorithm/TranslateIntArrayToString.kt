package com.example.algorithm

fun translateIntArrayToString(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    val result = ArrayList<Int>(arr.size)
    for (i in arr.indices) {
        if (i == 0) {
            result[0] = 1
            continue
        }
        if ((arr[i - 1] * 10 + arr[i]) >= 10 && (arr[i - 1] * 10 + arr[i]) < 26) {
            if (i == 1) result[i]++ else result[i] += result[i - 2]
        }
    }
    return result[arr.size - 1]
}