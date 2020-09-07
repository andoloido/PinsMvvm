package com.example.algorithm

//题目：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
fun findNthUglyNum(n: Int): Int {
    if (n < 0) return 0
    val arr = IntArray(n)
    arr[0] = 1
    var mut2 = 0
    var mut3 = 0
    var mut5 = 0
    for (i in 1 until n) {
        arr[i] = (arr[mut2] * 2).coerceAtMost((arr[mut3] * 3).coerceAtMost(arr[mut5 * 5]))
        if (arr[i] == arr[mut2] * 2) {
            mut2++
        }
        if (arr[i] == arr[mut3] * 3) {
            mut3++
        }
        if (arr[i] == arr[mut5] * 5) {
            mut5++
        }
    }
    return arr[n - 1]
}