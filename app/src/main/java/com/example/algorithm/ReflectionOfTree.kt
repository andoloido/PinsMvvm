package com.example.algorithm

fun mirror(root: TreeNode): TreeNode {
    val mRoot = TreeNode(root.value)
    buildMirror(root, mRoot)
    return mRoot
}

fun buildMirror(root: TreeNode?, mRoot: TreeNode?) {
    if (root == null) return
    mRoot?.left = root.right
    mRoot?.right = root.left
    buildMirror(root.left, mRoot?.right)
    buildMirror(root.right, mRoot?.left)
}
