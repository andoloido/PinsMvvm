package com.example.algorithm

fun findChildTree(rootNode1: TreeNode?, rootNode2: TreeNode?): Boolean {
    if (rootNode1 == null || rootNode2 == null) return false
    if (isChild(rootNode1, rootNode2)) {
        return true
    }
    return findChildTree(rootNode1.left, rootNode2) || findChildTree(rootNode1.right, rootNode2)
}

fun isChild(rootNode1: TreeNode?, rootNode2: TreeNode?): Boolean {
    if (rootNode1 == null || rootNode2 == null) return false
    return if (rootNode1.value == rootNode2.value) isChild(rootNode1.left, rootNode2.left) && isChild(rootNode1.right, rootNode2.right)
    else false
}