package com.example.algorithm

fun main() {
    print(findMinimum(intArrayOf(3, 4, 5, 6, 7, 8, 9, 1, 2)))
}

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
fun findMinimum(arr: IntArray): Int {
    //  if(array[end] == array[start] || array[mid] == array[end] || array[mid] == array[start]){
    //   return findMin(array);
    //   }
    //  出现下列情况，无法判断最小值位置，所以只能遍历
    //   if(array[mid] > array[start] && array[mid] < array[end]){
    //      return array[0];
    //        }
    //以上特殊只能遍历的情况我没有考虑
    if (arr.isEmpty()) return 0
    var start = 0
    var end = arr.size - 1
    var mid = start + (end - start).shr(1)
    while (true) {
        mid = start + (end - start).shr(1)
        if (arr[mid] > arr[start]) {
            start = mid
        } else if (arr[mid] < arr[end]) {
            end = mid
        }
        if ((start + 1) >= end) return arr[end]
    }
    return 0
}