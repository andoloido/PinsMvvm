package com.example.algorithm

class Node(val value: Int) {
    var next: Node? = null
}

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    val result = reversePrintNodeList(head)
    print(result)
}

//题目：输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
fun reversePrintNodeList(head: Node): ArrayList<Int> {
    fun addList(node: Node?, list: ArrayList<Int>) {
        if (node != null) addList(node.next, list)
        if (node != null) list.add(node.value)
    }

    val result = ArrayList<Int>()
    addList(head, result)
    return result
}