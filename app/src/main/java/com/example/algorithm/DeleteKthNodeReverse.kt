package com.example.algorithm

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    head.next?.next?.next?.next = Node(5)
    print(findKthNodeReverse(head, 5))
}

//题目：输入一个链表，输出该链表中倒数第k个结点。
fun findKthNodeReverse(head: Node, k: Int): Int? {
    if (k < 1) return null
    var i = k
    var temp: Node? = head
    while (i > 1) {
        temp = temp?.next
        i--
    }
    if (temp == null) return null
    var newHead: Node? = head
    while (temp?.next != null) {
        newHead = newHead?.next
        temp = temp.next
    }
    return newHead?.value
}