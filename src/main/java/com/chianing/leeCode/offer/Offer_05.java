package com.chianing.leeCode.offer;

/*
替换空格

请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

限制：
0 <= s 的长度 <= 10000
*/
public class Offer_05 {

    public static void main(String[] args) {
        String str = "We are happy.  ";
        System.out.printf("result is: %s%n", replaceSpace(str));
    }

    private static String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] charArr = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : charArr) {
            result.append(c == ' ' ? "%20" : c);
        }

        return result.toString();

    }

}
