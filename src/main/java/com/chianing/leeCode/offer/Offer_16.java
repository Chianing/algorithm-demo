package com.chianing.leeCode.offer;

/*
数值的整数次方

实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：
输入：x = 2.10000, n = 3
输出：9.26100
示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25

提示：
-100.0 <x< 100.0
-231<= n <=231-1
-104<= xn<= 104
 */
public class Offer_16 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", myPow(2, 4));
    }

    /**
     * x^n = x^(2*(n/2))
     *
     * @param x 底数
     * @param n 指数
     * @return 运算结果
     */
    private static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        long countCopy = n;
        if (countCopy < 0) {
            x = 1 / x;
            countCopy = -countCopy;
        }

        double result = 1;
        while (countCopy != 0) {
            if ((countCopy & 1) == 1) {
                // 指数为奇数
                result *= x;
            }
            x *= x;
            countCopy >>>= 1;
        }

        return result;
    }

}
