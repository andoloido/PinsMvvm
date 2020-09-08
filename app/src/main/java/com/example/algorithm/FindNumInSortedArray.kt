package com.example.algorithm

//题目一：数字在排序数组中出现的次数。
//统计一个数字在排序数组中出现的次数。例如，输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4。
fun findFrequencyInSortedArray(arr: IntArray, target: Int): Int {
    if (arr.isEmpty()) return 0
    if (!arr.contains(target)) return 0
    val start = findStart(arr, target)
    val end = findStart(arr, target)
    return end - start + 1
}

fun findStart(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start).shr(1)
    while ((mid > 0 && arr[mid - 1] == target) || arr[mid] != target) {
        if (arr[mid] < target) {
            mid = (mid + 1 + end).shr(1)
        } else {
            mid = (start + mid - 1).shr(1)
        }
    }
    return mid
}

fun findEnd(arr: IntArray, target: Int): Int {
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start).shr(1)
    while ((mid < end && arr[mid + 1] == target) || arr[mid] != target) {
        if (arr[mid] < target) {
            mid = (mid + 1 + end).shr(1)
        } else {
            mid = (start + mid - 1).shr(1)
        }
    }
    return mid
}

//题目二：0~n-1中缺失的数字
//一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0 ~ n-1之内。在范围0 ~ n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
fun findMissingNum(arr: IntArray): Int {
    val len = arr.size
    var start = 0
    var end = arr.size - 1
    var mid: Int
    while (start <= end) {
        mid = start + (end - start).shr(1)
        if (arr[mid] == mid) {
            start = mid + 1
        } else {
            if (mid == 0 || arr[mid - 1] == mid - 1) {
                return mid
            }
            end = mid - 1
        }
    }
    if (start == len) {
        return start
    }

    return 0
}

//题目三：数组中数值和下标相等的元素。
//假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1, 1, 3, 5}中，数字3和它的下标相等。
fun findNumEqualIndex(arr: IntArray): Int {
    val len = arr.size
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start).shr(1)
    while (arr[mid] != mid) {
        val temp = mid
        if (arr[mid] > mid) {
            mid = start + (mid - 1 - start).shr(1)
        } else {
            mid = mid + (end - mid - 1).shr(1)
        }
        if (temp == mid) {
            return -1
        }
    }
    return mid
}