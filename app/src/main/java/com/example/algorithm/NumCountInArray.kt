package com.example.algorithm

import kotlin.math.pow

fun main() {
    println(numCountInArray(intArrayOf(3, 3, 5, 5, 6, 6, 8, 8, 1, 4)))
    println(numCountInArray2(intArrayOf(3, 3, 3, 5, 5, 5, 6, 6, 6, 8, 8, 8, 9)))
}

//题目一：数组中只出现一次的两个数字。
//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
fun numCountInArray(arr: IntArray): ArrayList<Int> {
    val result = ArrayList<Int>()
    if (arr.isEmpty() || arr.size.and(1) == 1) return result

    val list1 = ArrayList<Int>()
    val list2 = ArrayList<Int>()

    var resultOperatorAnd = arr[0]
    for (i in 1 until arr.size) {
        resultOperatorAnd = resultOperatorAnd.xor(arr[i])
    }

    var index = 0
    while (true) {
        index++
        if (resultOperatorAnd.and(2.0.pow(index - 1.0).toInt()) == 1) break
    }

    for (num in arr) {
        if (num.and(2.0.pow(index - 1.0).toInt()) == 1) {
            list1.add(num)
        } else {
            list2.add(num)
        }
    }

    resultOperatorAnd = list1[0]
    for (i in 1 until list1.size) {
        resultOperatorAnd = resultOperatorAnd.xor(list1[i])
    }
    result.add(resultOperatorAnd)

    resultOperatorAnd = list2[0]
    for (i in 1 until list2.size) {
        resultOperatorAnd = resultOperatorAnd.xor(list2[i])
    }
    result.add(resultOperatorAnd)
    return result
}

//题目二：数组中唯一只出现一次的数字。
//在一个数组中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
fun numCountInArray2(arr: IntArray): ArrayList<Int> {
    val result = ArrayList<Int>()
    if (arr.isEmpty()) return result
    val auxiliaryArray = IntArray(32)
    for (index in auxiliaryArray.indices) {
        for (num in arr) {
            if (num.and(1 shl index) > 0) auxiliaryArray[index]++
        }
    }

    val list = auxiliaryArray.map { i -> i % 3 }

    var resultNum = 0
    for (index in list.indices) {
        resultNum += list[index].times(2.0.pow(index).toInt())
    }
    if (resultNum > 0) result.add(resultNum) else result.add(-resultNum)
    return result
}