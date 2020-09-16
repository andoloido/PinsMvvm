package com.example.algorithm

import java.util.*
import kotlin.collections.ArrayList

//题目一：和为s的两个数字。
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，则输出任意一对即可。
fun findNumPair(arr: IntArray, s: Int): ArrayList<Int> {
    var result = ArrayList<Int>()
    var start = 0
    var end = arr.size - 1
    while (start < end) {
        val total = arr[start] + end
        if (total == s) {
            result.add(arr[start])
            result.add(arr[end])
            return result
        }
        if (total < s) {
            start++
        } else {
            end--
        }
    }
    return result
}

fun main() {
    printArraySequence(15)
}

//题目二：和为s的连续正数序列。
//输入一个正数s，打印出所有和为s的连续正数序列（至少包含两个数）。例如，输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以打印出3个连续序列1 ~ 5、4 ~ 6和7 ~ 8。
fun printArraySequence(s: Int) {
    if (s < 1) return
    var result = ArrayList<ArrayList<Int>>()
    val mid = (s + 1) / 2
    var total = 0
    val auxiliaryList = ArrayList<Int>()
    for (i in 1..mid) {
        auxiliaryList.add(i)
        total += i
        when {
            total == s -> {
                result.add(ArrayList<Int>(auxiliaryList))
            }
            total > s -> {
                while (total > s) {
                    total -= auxiliaryList.get(0)
                    auxiliaryList.removeAt(0)
                }
                if (total == s) {
                    result.add(ArrayList<Int>(auxiliaryList))
                }
            }
        }
    }
}
