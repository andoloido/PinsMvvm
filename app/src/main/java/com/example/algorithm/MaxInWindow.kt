package com.example.algorithm

@ExperimentalStdlibApi
fun main() {
    print(maxInWindow(intArrayOf(2, 3, 4, 2, 6, 2, 5, 1), 3).toString())
}

//题目一：滑动窗口的最大值。
//
//给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
// 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
// {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
@ExperimentalStdlibApi
fun maxInWindow(arr: IntArray, windowSize: Int): ArrayList<Int> {
    val result = ArrayList<Int>()
    if (arr.isEmpty() || windowSize <= 0) return result
    if (windowSize > arr.size) return result

    val auxiliaryArrayList = AuxiliaryMaxArrayList()
    for (i in 0 until windowSize) {
        auxiliaryArrayList.offer(arr[i])
    }
    result.add(auxiliaryArrayList.getMaxValue())
    for (i in windowSize until arr.size) {
        auxiliaryArrayList.pull()
        auxiliaryArrayList.offer(arr[i])
        result.add(auxiliaryArrayList.getMaxValue())
    }
    return result
}

class AuxiliaryMaxArrayList() : ArrayList<Int>() {
    var maxArrayList = ArrayList<Int>()

    @ExperimentalStdlibApi
    fun offer(element: Int): Boolean {
        while (maxArrayList.isNotEmpty() && maxArrayList.get(maxArrayList.size - 1) <= element) {
            maxArrayList.removeLast()
        }
        maxArrayList.add(element)
        return super.add(element)
    }

    @ExperimentalStdlibApi
    fun pull(): Int {
        val lastIndex = size - 1
        if (maxArrayList[0] == get(0)) {
            maxArrayList.removeFirst()
        }
        return super.removeAt(0)
    }

    fun getMaxValue(): Int {
        return maxArrayList[0]
    }
}