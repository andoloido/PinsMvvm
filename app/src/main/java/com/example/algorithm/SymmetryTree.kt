package com.example.algorithm

fun findSymmetryTree(root1: TreeNode?, root2: TreeNode?): Boolean {
    if (root1 == null && root2 == null) return true
    if (root1 == null || root2 == null) return false
    return if (root1.value != root2.value) false else findSymmetryTree(root1.left, root2.right) && findSymmetryTree(root1.right, root2.left)
}