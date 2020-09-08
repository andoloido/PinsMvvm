package com.example.algorithm

//题目：输入两个链表，找出它们的第一个公共结点。
fun findFirstCommonNode(head1: Node, head2: Node): Node? {
    var temp1: Node? = head1
    var temp2: Node? = head2
    var len1 = 0
    var len2 = 0
    while (temp1 != null) {
        len1++
        temp1 = temp1.next
    }
    while (temp2 != null) {
        len2++
        temp2 = temp2.next
    }
    var tHead1: Node? = head1
    var tHead2: Node? = head2
    if (len1 >= len2) {
        for (i in 1 until (len1 - len2)) {
            tHead1 = tHead1?.next
        }
    } else {
        for (i in 1 until (len2 - len1)) {
            tHead2 = tHead2?.next
        }
    }
    while (tHead1 != tHead2) {
        tHead1 = tHead1?.next
        tHead2 = tHead2?.next
    }
    return tHead1
}