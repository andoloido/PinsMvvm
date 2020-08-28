package com.example.algorithm

//题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
fun verifySequenceOfBST(arr: IntArray): Boolean {
    if (arr.isEmpty()) return false
    return verifySequenceOfBST(arr, 0, arr.size - 1)
}

fun verifySequenceOfBST(arr: IntArray, start: Int, end: Int): Boolean {
    if (start > end) return true
    var mid = start
    while (mid < end && arr[mid] < arr[end]) {
        mid++
    }
    mid++
    while (mid < end) {
        if (arr[mid] < arr[end]) return false
        mid++
    }
    return verifySequenceOfBST(arr, start, mid - 1) && verifySequenceOfBST(arr, mid, end - 1)
}