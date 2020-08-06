package com.example.algorithm

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*
import kotlin.Comparator

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val result = findNLeastNum(intArrayOf(4, 5, 1, 6, 2, 7, 3, 8), 5)
    print(result.contentToString())
}

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
@RequiresApi(Build.VERSION_CODES.N)
fun findNLeastNum(arr: IntArray, n: Int): IntArray {
    if (arr.isEmpty() || arr.size < n) throw Exception("arr error")

    val priorityQueue: PriorityQueue<Int> =
        PriorityQueue(Comparator<Int> { p0, p1 -> p1.compareTo(p0) })

    for (i in arr) {
        if (priorityQueue.size < n) {
            priorityQueue.offer(i)
        } else {
            if (priorityQueue.peek() > i) {
                priorityQueue.poll()
                priorityQueue.offer(i)
            }
        }
    }
    return priorityQueue.toIntArray()
}