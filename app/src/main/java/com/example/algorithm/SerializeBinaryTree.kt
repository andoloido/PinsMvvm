package com.example.algorithm

class TreeNodeChar(val value: Char) {
    var left: TreeNodeChar? = null
    var right: TreeNodeChar? = null
}

fun main() {
    val root = TreeNodeChar('a')
    root.left = TreeNodeChar('b')
    root.right = TreeNodeChar('c')
    root.left?.left = TreeNodeChar('d')
    root.left?.right = TreeNodeChar('e')
    root.right?.left = TreeNodeChar('f')
    root.right?.right = TreeNodeChar('g')
    val serializedString = serializeTree(root)
    print(serializedString)
    val result = deserializeTree(serializedString)
}

fun serializeTree(root: TreeNodeChar): String {
    val result = StringBuilder()
    result.append(root.value)
    result.append(',')
    addTreeNode(root.left, result)
    addTreeNode(root.right, result)
    return result.toString()
}

fun addTreeNode(root: TreeNodeChar?, result: StringBuilder) {
    if (root == null) {
        result.append('$')
        result.append(',')
        return
    }
    result.append(root.value)
    result.append(',')
    addTreeNode(root.left, result)
    addTreeNode(root.right, result)
}

var mIndex = 0

fun deserializeTree(treeString: String): TreeNodeChar? {
    val charArray = treeString.toCharArray().filter {
        it != ','
    }
    return deserialize(charArray)
}

fun deserialize(charArray: List<Char>): TreeNodeChar? {
    if (mIndex == charArray.size || charArray[mIndex] == '$') {
        return null
    }
    val node = TreeNodeChar(charArray[mIndex])
    mIndex++
    node.left = deserialize(charArray)
    mIndex++
    node.right = deserialize(charArray)
    return node
}
