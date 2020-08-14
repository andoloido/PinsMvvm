package com.example.algorithm

//题目一：在O(1)时间内删除链表节点。
//给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
fun deleteNodeInList(head: Node, target: Node) {
    var temp: Node? = target
    if (temp!!.next == null) {
        temp = null
    } else if (head == target) {
        temp = null
    } else {
        temp.next?.run {
            target.value = this.value
            target.next = this.next
        }
    }
}