package com.example.algorithm

fun main() {
    val head1 = Node(1)
    head1.next = Node(2)
    head1.next?.next = Node(3)
    head1.next?.next?.next = Node(4)

    val head2 = Node(1)
    head2.next = Node(2)
    head2.next?.next = Node(3)
    head2.next?.next?.next = Node(4)
    val result = mergeNodeList(head1, head2)
}

fun mergeNodeList(head1: Node, head2: Node): Node {
    var newHead: Node? = Node(0)
    var head1Temp: Node? = head1
    var head2Temp: Node? = head2
    if (head1Temp!!.value <= head2Temp!!.value) {
        newHead = head1Temp
        head1Temp = head1Temp.next
    } else {
        newHead = head2
        head2Temp = head2Temp.next
    }
    val tempHead = newHead
    while (head1Temp != null && head2Temp != null) {
        if (head1Temp.value <= head2Temp.value) {
            newHead?.next = head1Temp
            head1Temp = head1Temp.next
        } else {
            newHead?.next = head2Temp
            head2Temp = head2Temp.next
        }
        newHead = newHead?.next
    }

    newHead?.next = head1Temp ?: head2Temp
    return tempHead
}