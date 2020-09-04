package com.example.algorithm

//题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
// 假设字符串中只包含'a'~'z'的字符。例如，在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4。
fun findLongestSubstring(str: String): Int {
    val arr = IntArray(26) { i -> -1 }
    val charArr = str.toCharArray()
    var curL = 0
    var maxL = 0
    for (index in charArr.indices) {
        if (arr[charArr[index] - 'a'] == 1 || (index - arr[charArr[index] - 'a']) > curL) {
            curL++
        } else {
            if (curL > maxL) {
                maxL = curL
            }
            curL = index - arr[charArr[index] - 'a']
        }
        arr[charArr[index] - 'a'] = index
    }

    return Math.max(curL, maxL)
}