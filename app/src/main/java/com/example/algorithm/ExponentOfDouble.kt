package com.example.algorithm

fun main() {
    print(exponentOfDouble(1.1, 2))
}

//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
fun exponentOfDouble(base: Double, exponent: Int): Double {
    fun exponentDouble(base: Double, exponent: Int): Double {
        if (exponent == 0) return 1.0
        if (exponent == 1) return base
        var result = exponentDouble(base, exponent.shr(1))
        result *= result
        if (exponent.and(1) == 1) result *= base
        return result
    }

    var negative = false
    var exponentNew = exponent
    var baseNew = base
    if (exponent == 0) return 1.0
    if (exponent == 1) return base
    if (exponent < 0) {
        negative = true
        exponentNew = -exponentNew
    }
    var result = exponentDouble(base, exponentNew)
    return if (negative) 1 / result else result
}