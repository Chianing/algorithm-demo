package com.chianing.leeCode.offer;

/*
斐波那契数列

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
斐波那契数列的定义如下：
F(0) = 0, F(1)= 1
F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：1
示例 2：
输入：n = 5
输出：5

提示：
0 <= n <= 100
0 1 1 2 3 5 8 13 21 34 55 89
0 1 2 3 4 5 6 7  8  9  10 11
 */
public class Offer_10_01 {
    public static void main(String[] args) {

        System.out.printf("n is: %s, res ult is: %s%n", 2, fib(2));
        System.out.printf("n is: %s, result is: %s%n", 5, fib(5));
        System.out.printf("n is: %s, result is: %s%n", 45, fib(45));

    }

    private static int fib(int n) {
        if (n == 0) {
            return 0;
        }

        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;

    }

}
