package com.chianing.leeCode.offer;

/*
不用加减乘除做加法

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

示例:
输入: a = 1, b = 1
输出: 2

提示：
a,b均可能是负数或 0
结果不会溢出 32 位整数
 */
public class Offer_65 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", add(1, 1));
    }

    private static int add(int a, int b) {
        int temp;
        while (b != 0) {
            temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }
        return a;
    }

}
