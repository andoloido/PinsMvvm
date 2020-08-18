package com.example.algorithm

import java.util.*

class Solution {
    val stack: Stack<Int> = Stack()
    val minStack: Stack<Int> = Stack()

    fun push(num: Int) {
        stack.push(num)
        when {
            minStack.isEmpty() -> minStack.push(num)
            minStack.peek() < num -> {
                minStack.push(minStack.peek())
            }
            else -> {
                minStack.push(num)
            }
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            stack.pop()
            minStack.pop()
        }
    }

    fun min(): Int {
        return minStack.peek()
    }
}