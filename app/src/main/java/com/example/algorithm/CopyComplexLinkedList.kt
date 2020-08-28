package com.example.algorithm

fun copyComplexLinkedList(head: Node): Node {
    doubleList(head)
    linkList(head)
    return cutList(head)
}

fun cutList(head: Node): Node {
    val newHead = head.next!!
    var node: Node? = newHead
    while (node != null) {
        node.next = node.next?.next
        node = node.next?.next
    }
    return newHead
}

fun linkList(head: Node) {
    var node: Node? = head
    while (node != null) {
        node.next?.randow = node.randow?.next
        node = node.next?.next
    }
}

fun doubleList(head: Node) {
    var node: Node? = head
    while (node != null) {
        val copyNode = Node(node.value)
        copyNode.next = node.next
        node.next = copyNode
        node = node.next?.next
    }
}
