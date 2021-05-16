package com.chianing.leeCode.hot100;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 5460 👎 0

import java.util.HashMap;
import java.util.Map;

public class Hot_03 {

    public static void main(String[] args) {
        String str = "dvdf";

        System.out.printf("result is: %s", lengthOfLongestSubstring(str));

    }

    private static int lengthOfLongestSubstring(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }

        int maxLen = 0;
        Integer tempIndex;
        Map<Character, Integer> tempMap = new HashMap<>();

        for (int start = 0, end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            tempIndex = tempMap.get(c);
            start = tempIndex == null ? start : Math.max(tempIndex, start);
            maxLen = Math.max(end - start + 1, maxLen);
            tempMap.put(c, end + 1);
        }

        return maxLen;
    }

}
