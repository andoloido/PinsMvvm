package com.example.algorithm

fun pathTotalValue(root: TreeNode, target: Int): ArrayList<ArrayList<Int>> {
    val result = ArrayList<ArrayList<Int>>()
    findPathTotalValue(root, target, ArrayList(), 0, result)
    return result
}

fun findPathTotalValue(node: TreeNode, target: Int, tempList: ArrayList<Int>, totalNow: Int, result: ArrayList<ArrayList<Int>>) {
    tempList.add(node.value)
    if (node.left == null && node.right == null) {
        if (target == totalNow + node.value) {
            result.add(tempList)
        }
    } else {
        node.right?.run {
            findPathTotalValue(this, target, tempList, totalNow + node.value, result)
        }
        node.left?.run {
            findPathTotalValue(this, target, tempList, totalNow + node.value, result)
        }
    }
    tempList.removeAt(tempList.size - 1)
}
