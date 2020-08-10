package com.example.algorithm

import java.util.*

class QueueWithTwoStack {
    val stack1 = Stack<Int>()
    val stack2 = Stack<Int>()

    fun offer(num: Int) {
        stack1.push(num)
    }

    fun pull(): Int {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop())
            }
        }
        return stack2.pop()
    }
}