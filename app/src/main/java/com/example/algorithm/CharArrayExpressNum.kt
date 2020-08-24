package com.example.algorithm

fun checkIsNum(str: CharArray): Boolean {
    if (str.isEmpty()) return false
    var hasDot = false
    var hasE = false
    for (i in str.indices) {
        val char = str[i]
        if (isNumber(char)) {
            continue
        }
        if (isPlusMinus(char)) {
            if (i == 0) continue
            if (isE(str[i - 1])) continue
            return false
        }
        if (isE(char)) {
            if (hasE) return false
            hasE = true
            hasDot = true
        }
        if (char == '.') {
            if (hasDot) return false
            hasDot = true
        }
        return false
    }
    return true
}

fun isE(c: Char): Boolean {
    return c == 'E' || c == 'e'
}

fun isPlusMinus(c: Char): Boolean {
    return c == '+' || c == '-'
}

fun isNumber(c: Char): Boolean {
    return c in '0'..'9'
}