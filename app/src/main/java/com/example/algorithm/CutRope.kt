package com.example.algorithm

import java.lang.Exception

fun main() {
    print(cutRope(8))
}

//题目：给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），
// 每段绳子的长度记为k[0],k[1],···,k[m]。请问k[0]×k[1]×···×k[m]可能的最大乘积是多少？
// 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
fun cutRope(len: Int): Int {
    if (len <= 1) throw Exception("no a valid num")
    //优化，map改为数组，用index取值
    val mapMax = HashMap<Int, Int>(len)
    mapMax[1] = 1
    mapMax[2] = 1
    mapMax[3] = 2
    mapMax[4] = 4
    for (n in 5..len) {
        var max = 0
        for (i in 1..n / 2 + 1) {
            max = Math.max(max, i.times(Math.max(n - i, mapMax[n - i]!!)))
        }
        mapMax[n] = max
    }
    return mapMax[len]!!
}