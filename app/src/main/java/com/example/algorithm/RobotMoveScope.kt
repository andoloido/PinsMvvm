package com.example.algorithm

fun main() {
    robotMoveScope(5, 10, 10)
}

//题目：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
// 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
// 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38）
// ，因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
var count = 0
fun robotMoveScope(threshold: Int, rows: Int, columns: Int) {
    val visited = Array(rows) {
        BooleanArray(columns) {
            false
        }
    }
    add(threshold, 0, 0, rows, columns, visited)
    print(count)
}

fun add(threshold: Int, row: Int, column: Int, rows: Int, columns: Int, visited: Array<BooleanArray>) {
    if (row < 0 || row > rows - 1 || column < 0 || column > columns - 1 || visited[row][column]) return
    if (sum(row) + sum(column) > threshold) return
    visited[row][column] = true
    count++
    add(threshold, row - 1, column, rows, columns, visited)
    add(threshold, row + 1, column, rows, columns, visited)
    add(threshold, row, column - 1, rows, columns, visited)
    add(threshold, row, column + 1, rows, columns, visited)
}

fun sum(num: Int): Int {
    var temp = num
    var result = 0
    while (temp > 0) {
        result += temp % 10
        temp /= 10
    }
    return result
}