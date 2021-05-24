package com.chianing.leeCode.offer;

/*
正则表达式匹配

请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

示例 1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例 2:
输入:
s = "aa"
p = "a*"
输出: true
解释:因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例3:
输入:
s = "ab"
p = ".*"
输出: true
解释:".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

示例 4:
输入:
s = "aab"
p = "c*a*b"
输出: true
解释:因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

示例 5:
输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
s可能为空，且只包含从a-z的小写字母。
p可能为空，且只包含从a-z的小写字母以及字符.和*，无连续的 '*'。
 */
public class Offer_19 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", isMatch("mississippi", "mis*is*p*."));
        System.out.printf("result is: %s%n", isMatch("aab", "c*a*b"));
    }

    private static boolean isMatch(String s, String p) {
        int strLength = s.length();
        int patternLength = p.length();
        boolean[][] resultArr = new boolean[strLength + 1][patternLength + 1];

        for (int i = 0; i <= strLength; i++) {
            for (int j = 0; j <= patternLength; j++) {
                if (j == 0) {
                    // 字符串和正则表达式都为空的时候 是匹配的
                    resultArr[i][j] = i == 0;
                    continue;
                }

                if (p.charAt(j - 1) != '*') {
                    // 如果不是* 则判断字符串和正则该位置字符是否匹配 或正则该位置是否为. 如果满足 则考虑该位置前的字符
                    if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')) {
                        resultArr[i][j] = resultArr[i - 1][j - 1];
                    }
                    continue;
                }

                if (j < 2) {
                    continue;
                }

                // 如果是*
                // 去掉正则的前两位
                resultArr[i][j] |= resultArr[i][j - 2];

                if (i >= 1 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                    // 字符串向前移动一位
                    resultArr[i][j] |= resultArr[i - 1][j];
                }
            }

        }

        return resultArr[strLength][patternLength];
    }

}
