package com.example.algorithm

class FindKthLeastTreeNode {
    var mIndex = 0

    //题目：给定一棵二叉搜索树，请找出其中的第k小的结点。例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
    fun findKthLeastTreeNode(root: TreeNode?, k: Int): TreeNode? {
        if (k < 1 || root == null) return null
        if (root.left != null) {
            val left = findKthLeastTreeNode(root.left, k)
            if (left != null) return left
        }
        if (++mIndex == k) return root
        if (root.right != null) {
            val right = findKthLeastTreeNode(root.right, k)
            if (right != null) return right
        }
        return null
    }
}
