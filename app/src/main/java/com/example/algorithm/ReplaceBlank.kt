package com.example.algorithm

fun main(arr: Array<String>) {
    print(replaceBlank(StringBuffer("We are Happy")))
}

//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
fun replaceBlank(sentence: StringBuffer): String {
    var len = sentence.length
    val originalLen = len
    for (c in sentence) {
        if (c == ' ') {
            len += 2
        }
    }
    sentence.setLength(len)
    len--
    for (index in originalLen - 1 downTo 0) {
        if (sentence[index] == ' ') {
            sentence.setCharAt(len--, '0')
            sentence.setCharAt(len--, '2')
            sentence.setCharAt(len--, '%')
        } else {
            sentence.setCharAt(len--, sentence[index])
        }
    }
    return String(sentence)
}