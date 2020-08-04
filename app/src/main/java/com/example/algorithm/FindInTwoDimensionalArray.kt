package com.example.algorithm

fun main(args: Array<String>) {
    val arr = Array(3) { IntArray(3) }
    findInTwoDimensionalArray(arr, 3)
}

//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
//请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
fun findInTwoDimensionalArray(arr: Array<IntArray>, target: Int): Boolean {
    if (arr.isEmpty()) return false
    var row = 0
    var col = arr[0].size
    while (row < arr.size && col != 0) {
        when {
            arr[row - 1][col - 1] > target -> col--
            arr[row - 1][col - 1] < target -> row++
            else -> return true
        }
    }
    return false
}
