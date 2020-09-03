package com.example.algorithm

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    val flow = MedianInDataFlow()
    flow.insert(1)
    println(flow.getMedian())

    flow.insert(3)
    println(flow.getMedian())

    flow.insert(7)
    println(flow.getMedian())

    flow.insert(4)
    println(flow.getMedian())

    flow.insert(5)
    println(flow.getMedian())

    flow.insert(13)
    println(flow.getMedian())

    flow.insert(23)
    println(flow.getMedian())

    flow.insert(2)
    println(flow.getMedian())

    flow.insert(9)
    println(flow.getMedian())

    flow.insert(8)
    println(flow.getMedian())

}

//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
// 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
// 使用GetMedian()方法获取当前读取数据的中位数
@RequiresApi(Build.VERSION_CODES.N)
class MedianInDataFlow {
    var size = 0
    private val mMinQueue = PriorityQueue<Int>()

    private val mMaxQueue = PriorityQueue<Int>(Comparator { o1: Int, o2: Int -> o2 - o1 })

    fun insert(num: Int) {
        val minSize = mMinQueue.size
        val maxSize = mMaxQueue.size
        if (minSize == maxSize) {
            if (maxSize == 0) {
                mMaxQueue.add(num)
            } else if (mMinQueue.peek() < num) {
                mMinQueue.add(num)
                mMaxQueue.add(mMinQueue.poll())
            } else {
                mMaxQueue.add(num)
            }
        } else {
            if (mMaxQueue.peek() > num) {
                mMaxQueue.add(num)
                mMinQueue.add(mMaxQueue.poll())
            } else {
                mMinQueue.add(num)
            }
        }
        size++
    }

    fun getMedian(): Int? {
        if (size == 0) return null
        return if (size.and(1) == 1) {
            mMaxQueue.peek()
        } else {
            (mMaxQueue.peek() + mMinQueue.peek()).div(2)
        }
    }
}