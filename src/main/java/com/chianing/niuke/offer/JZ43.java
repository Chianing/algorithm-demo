package com.chianing.niuke.offer;

/**
 * title: JZ43 左旋转字符串
 * des:
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * -----------------------
 * input: abcXYZdef,3
 * output: XYZdefabc
 */
public class JZ43 {

    public static void main(String[] args) {
        String str1 = "";
        String str2 = "abc";
        String str3 = "abcdefg";

        System.out.printf("case1, str1: %s, result is: %s%n", str1, concatStr(str1, 1));
        System.out.println("------------------");
        System.out.printf("case2, str2: %s, result is: %s%n", str2, concatStr(str2, 5));
        System.out.println("------------------");
        System.out.printf("case3, str3: %s, result is: %s%n", str3, concatStr(str3, 3));

    }

    private static String concatStr(String str, int n) {
        if (str == null || "".equals(str) || n == 0 || n >= str.length()) {
            return str;
        }

        String startStr = str.substring(0, n);
        String endStr = str.substring(n);

        return endStr + startStr;
    }
}
