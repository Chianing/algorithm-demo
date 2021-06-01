package com.chianing.leeCode.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/*
第一个只出现一次的字符

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:
s = "abaccdeff"
返回 "b"
s = ""
返回 " "

限制：
0 <= s 的长度 <= 50000
 */
public class Offer_50 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", firstUniqChar("abaccdeff"));
    }

    private static char firstUniqChar(String s) {
        if (s == null || "".equals(s)) {
            return ' ';
        }

        char[] chars = s.toCharArray();
        Map<Character, Boolean> tempMap = new LinkedHashMap<>();

        for (char c : chars) {
            tempMap.put(c, tempMap.containsKey(c));
        }

        for (Map.Entry<Character, Boolean> entry : tempMap.entrySet()) {
            if (!entry.getValue()) {
                return entry.getKey();
            }
        }

        return ' ';
    }

}
