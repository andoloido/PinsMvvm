package com.example.algorithm

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    head.next?.next?.next?.next = Node(5)
    val result = reverseList(head)
}

//题目：输入一个链表，反转链表后，输出新链表的表头。
fun reverseList(head: Node): Node? {
    var now: Node? = head
    var pre: Node? = null
    var after: Node? = head.next
    while (after != null) {
        after = now?.next
        now?.next = pre
        pre = now
        now = after
    }
    return pre
}