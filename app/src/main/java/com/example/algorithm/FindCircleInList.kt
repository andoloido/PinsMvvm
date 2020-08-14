package com.example.algorithm

fun main() {
    val head = Node(1)
    head.next = Node(2)
    head.next?.next = Node(3)
    head.next?.next?.next = Node(4)
    head.next?.next?.next?.next = Node(5)
    head.next?.next?.next?.next?.next = head.next
    print(findCircleEntryInList(head)?.value)
}

fun findCircleEntryInList(head: Node): Node? {
    if (head.next == null) return null
    var slow: Node? = head
    var fast: Node? = head.next?.next
    while (slow != null && fast != null && fast != slow) {
        slow = slow.next
        fast = fast.next?.next
    }
    if (fast == null) return null
    else {
        val meetingNode = fast
        var temp = meetingNode.next
        var count = 1
        while (temp != meetingNode) {
            temp = temp?.next
            count++
        }
        var tempHead: Node? = head
        var tempHead2: Node? = head
        while (count > 0) {
            tempHead = tempHead?.next
            count--
        }
        while (tempHead != tempHead2) {
            tempHead = tempHead?.next
            tempHead2 = tempHead2?.next
        }
        return tempHead
    }
}