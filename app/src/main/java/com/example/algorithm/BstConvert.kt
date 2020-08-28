package com.example.algorithm

var mLast: TreeNode? = null
fun convertToDoubleLinkedList(root: TreeNode): TreeNode {
    convert(root)
    var temp: TreeNode? = root
    while (temp?.left != null) {
        temp = temp.left
    }
    return temp!!
}

fun convert(node: TreeNode) {
    if (node.left != null) {
        convert(node.left!!)
    }
    node.left = mLast
    if (mLast != null) {
        mLast?.right = node
    }
    mLast = node
    if (node.right != null) {
        convert(node.right!!)
    }
}
