package com.example.algorithm

class TreeNodeDepth {
    //题目一：二叉树的深度
    //
    //输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
    fun getTreeDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return Math.max(getTreeDepth(root.left), getTreeDepth(root.right)) + 1
    }

    var mDepth = 0

    //题目二：平衡二叉树
    //
    //输入一棵二叉树，判断该二叉树是否是平衡二叉树。如果某二叉树中任意节点的左、右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
    fun isBalanceBinaryTree(root: TreeNode?): Boolean {
        if (root == null) return true
        if (!isBalanceBinaryTree(root.left)) {
            return false
        }
        val left = mDepth
        if (!isBalanceBinaryTree(root.right)) {
            return false
        }
        val right = mDepth
        val diff = Math.abs(left - right)
        if (diff > 1) {
            return false
        } else {
            mDepth = diff
            return true
        }
    }
}