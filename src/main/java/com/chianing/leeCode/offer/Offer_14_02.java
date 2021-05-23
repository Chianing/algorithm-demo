package com.chianing.leeCode.offer;

/*
剪绳子

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：
输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36

提示：
2 <= n <= 1000
 */
public class Offer_14_02 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", cuttingRope(5));
    }

    private static int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int count = n / 3, remainder = n % 3, mod = 1000000007;
        long result = 1;

        for (int i = 1; i < count; i++) {
            result = result * 3 % mod;
        }

        switch (remainder) {
            case 0:
                return (int) (result * 3 % mod);
            case 1:
                return (int) (result * 4 % mod);
            case 2:
                return (int) (result * 6 % mod);
            default:
                return 0;
        }
    }

}
