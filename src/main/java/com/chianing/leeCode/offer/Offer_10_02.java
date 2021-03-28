package com.chianing.leeCode.offer;

/*
青蛙跳台阶

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：
输入：n = 2
输出：2
示例 2：
输入：n = 7
输出：21
示例 3：
输入：n = 0
输出：1

提示：
0 <= n <= 100
 */
public class Offer_10_02 {

    public static void main(String[] args) {
        System.out.printf("n is: %s, result is: %s%n", 7, numWays(7));
    }

    public static int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int a = 1, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }

        return b;

    }

}
