package com.example.algorithm

//题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于0）。
// 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格，直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计算你最多能拿到多少价值的礼物？
fun maxValueInPresents(arr: ArrayList<ArrayList<Int>>): Int {
    if (arr.isEmpty()) return 0
    val row = arr.size
    val col = arr[0].size
    val maxArr: ArrayList<ArrayList<Int>> = ArrayList()
    for (i in 0 until row) {
        maxArr.add(ArrayList())
    }
    maxArr[0].add(arr[0][0])
    for (i in 1 until col) {
        maxArr[0].add(maxArr[0][i - 1] + arr[0][i])
    }
    maxArr[1].add(arr[1][0])
    for (i in 1 until row) {
        maxArr[i].add(maxArr[i - 1][0] + arr[i][0])
    }
    for (i in 1 until row) {
        for (j in 1 until col) {
            if (maxArr[i - 1][j] > maxArr[i][j - 1]) {
                maxArr[i][j] = maxArr[i - 1][j] + arr[i][j]
            } else {
                maxArr[i][j] = maxArr[i][j - 1] + arr[i][j]
            }
        }
    }
    return maxArr[row - 1][col - 1]
}


fun maxValueInPresents2(arr: ArrayList<ArrayList<Int>>): Int {
    if (arr.isEmpty()) return 0
    val row = arr.size
    val col = arr[0].size
    val maxArr = ArrayList<Int>(initialCapacity = col)
    for (i in 0 until row) {
        for (j in 1 until col) {
            var top = 0
            var left = 0
            if (i > 0) {
                top = maxArr[j]
            }
            if (j > 0) {
                left = maxArr[j - 1]
            }
            maxArr[j] = top.coerceAtLeast(left) + arr[i][j]
        }
    }
    return maxArr[col - 1]
}