package com.chianing.leeCode.offer;

import java.util.HashMap;
import java.util.Map;

/*
最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。

提示：
s.length <= 40000
 */
public class Offer_48 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", lengthOfLongestSubstring("pwwkew"));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }

        int result = 0;
        char tempChar;
        Integer tempIndex;
        Map<Character, Integer> tempMap = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            tempChar = s.charAt(end);
            tempIndex = tempMap.get(tempChar);
            start = tempIndex == null ? start : Math.max(start, tempIndex);
            result = Math.max(result, end - start + 1);
            tempMap.put(tempChar, end + 1);
        }

        return result;
    }
}
