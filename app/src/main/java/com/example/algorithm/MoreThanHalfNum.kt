package com.example.algorithm

fun main() {
    print(findMoreThanHalfNum(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 3, 4, 5)))
}

fun findMoreThanHalfNum(arr: IntArray): Int {
    if (arr.isEmpty()) throw Exception("check arr")
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start).shr(1)
    var index = findPartition(arr, start, end)
    while (index != mid) {
        if (index > mid) {
            end = index - 1
        }
        if (index < mid) {
            start = end + 1
        }
        index = findPartition(arr, start, end)
    }
    return arr[index]
}

fun findPartition(arr: IntArray, start: Int, end: Int): Int {
    if (start >= end) {
        return end
    }
    val flag = arr[start]
    var head = start + 1
    var tail = end
    while (head < tail) {
        while (arr[tail] > flag && head < tail) {
            tail--
        }
        if (head < tail) {
            exchange(arr, head, tail)
            tail--
        }

        while (arr[head] <= flag && head < tail) {
            head++
        }
        if (head < tail) {
            exchange(arr, head, tail)
            head++
        }
    }
    arr[head] = flag
    return head
}

fun exchange(arr: IntArray, head: Int, tail: Int) {
    val temp = arr[head]
    arr[head] = arr[tail]
    arr[tail] = temp
}


