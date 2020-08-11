package com.example.algorithm

//题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
// 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
// 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径
// ，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
fun findPath(arr: Array<CharArray>, targetArray: CharArray): Boolean {
    if (arr.isEmpty() || arr[0].isEmpty() || targetArray.isEmpty()) return false
    val row = arr.size
    val column = arr[0].size
    val visited = Array(row) {
        BooleanArray(column) {
            false
        }
    }
    for (i in 0 until row) {
        for (j in 0 until column) {
            if (find(arr, i, j, targetArray, 0, visited)) {
                return true
            }
        }
    }
    return false
}

fun find(arr: Array<CharArray>, row: Int, column: Int, targetArray: CharArray, targetIndex: Int, visited: Array<BooleanArray>): Boolean {
    if (row < 0 || row > arr.size - 1 || column < 0 || column > arr[0].size - 1 || visited[row][column]) {
        return false
    }
    visited[row][column] = true
    if (arr[row][column] == targetArray[targetIndex] && targetIndex == targetArray.size - 1) return true

    return if (arr[row][column] == targetArray[targetIndex]) {
        visited[row][column] = true
        if (find(arr, row, column - 1, targetArray, targetIndex + 1, visited)
            || find(arr, row, column + 1, targetArray, targetIndex + 1, visited)
            || find(arr, row - 1, column, targetArray, targetIndex + 1, visited)
            || find(arr, row + 1, column, targetArray, targetIndex + 1, visited)
        ) {
            true
        } else {
            visited[row][column] = false
            false
        }
    } else {
        false
    }
}