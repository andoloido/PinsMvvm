package com.example.algorithm

import java.lang.Exception

class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    var parent: TreeNode? = null
}

fun main() {
    val result =
        rebuildBinaryTree(intArrayOf(1, 2, 4, 7, 3, 5, 6, 8), intArrayOf(4, 7, 2, 1, 5, 3, 8, 6))
    result
}

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
fun rebuildBinaryTree(arr1: IntArray, arr2: IntArray): TreeNode? {
    if (arr1.isEmpty() || arr2.isEmpty() || arr1.size != arr2.size) throw Exception("arr error")

    fun build(
        arr1: IntArray,
        arr2: IntArray,
        arr1Start: Int,
        arr2Start: Int,
        arr2End: Int
    ): TreeNode? {
        if (arr2End == arr2Start) return TreeNode(arr2[arr2Start])
        val root = TreeNode(arr1[arr1Start])
        var index = arr2.indexOf(arr1[arr1Start])
        if (index != arr2Start) root.left = build(arr1, arr2, arr1Start + 1, arr2Start, index - 1)
        if (index != arr2End) root.right =
            build(arr1, arr2, arr1Start + 1 + (index - arr2Start), index + 1, arr2End)
        return root
    }

    val arr2End = arr2.size - 1

    return build(arr1, arr2, 0, 0, arr2End)
}