package com.example.algorithm

import java.util.*

fun main() {
    println(isPopOrderSimplify(intArrayOf(1, 2, 3, 4, 5), intArrayOf(4, 5, 3, 2, 1)))
    println(isPopOrderSimplify(intArrayOf(1, 2, 3, 4, 5), intArrayOf(1, 2, 5, 3, 4)))
}

fun isPopOrder(arr1: IntArray, arr2: IntArray): Boolean {
    if (arr1.size != arr2.size) return false
    var index = 0
    val stack = Stack<Int>()
    for (i in arr2.indices) {
        if (stack.isNotEmpty() && stack.peek() == arr2[i]) {
            if (i == arr2.size - 1) return true
            //stack pop break
            stack.pop()
            continue
        } else if (index == arr2.size) return false
        //否则就一直push
        while (arr1[index] != arr2[i]) {
            stack.push(arr1[index++])
            if (index >= arr1.size) return false
        }
        index++
        if (i == arr1.size - 1) return true
    }
    return true
}

fun isPopOrderSimplify(arr1: IntArray, arr2: IntArray): Boolean {
    if (arr1.size != arr2.size) return false
    var index = 0
    val stack = Stack<Int>()
    for (i in arr2.indices) {
        while (stack.isEmpty() || stack.peek() != arr2[i]) {
            if (index == arr1.size) break
            stack.push(arr1[index++])
        }
        if (stack.pop() != arr2[i]) {
            return false
        }
    }
    return true
}