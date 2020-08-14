package com.example.algorithm

fun main() {
    val head = Node(4)
    head.next = Node(4)
    head.next?.next = Node(4)
    //val result = deleteNodeInList(head, head.next!!.next!!)
    val result1 = deleteDuplicateNodeInList(head)
    return
}

//题目一：在O(1)时间内删除链表节点。
//给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间内删除该节点。
fun deleteNodeInList(head: Node, target: Node): Node? {
    if (target.next != null) {
        target.value = target.next!!.value
        target.next = target.next?.next
        return head
    } else if (head == target) {
        return null
    } else {
        var temp: Node? = head
        while (temp?.next?.next != null) {
            temp = temp.next
        }
        temp?.next = null
        return head
    }
    return head
}

//题目二：删除链表中重复的节点。
//在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
fun deleteDuplicateNodeInList(head: Node) {
    var last: Node? = head
    var temp: Node? = head.next
    var value = head.value
    while (temp != null) {
        if (temp.value != value) {
            value = temp.value
            last?.next = temp
            last = last?.next
        }
        temp = temp.next
    }
    if (last == head) last.next = null
}