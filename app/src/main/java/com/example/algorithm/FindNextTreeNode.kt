package com.example.algorithm

fun main() {
    val root = rebuildBinaryTree(intArrayOf(1, 2, 4, 7, 3, 5, 6, 8), intArrayOf(4, 7, 2, 1, 5, 3, 8, 6))
    root?.let {
        midTraverse(it, 4)
    }
}

//题目：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
// 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
fun findNextTreeNode(source: TreeNode): TreeNode? {
    //1.右边还有node,找右边的最左边
    if (source.right != null) {
        var temp = source.right
        while (temp?.left != null) {
            temp = temp.left
        }
        return temp
    }

    var temp: TreeNode? = source
    //2.右边没有node了,找第一个当前节点是父节点左child的节点
    while (temp?.parent != null) {
        if (temp.parent?.left == temp.parent) return temp.parent
        else temp = temp.parent
    }
    return null
}

//自己写的中序遍历
fun midTraverse(root: TreeNode, target: Int) {
    val arrayList = ArrayList<Int>()

    fun traverse(node: TreeNode?) {
        if (node == null) return
        traverse(node.left)
        arrayList.add(node.value)
        traverse(node.right)
    }
    traverse(root)
    print(arrayList)
}