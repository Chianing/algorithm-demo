package com.chianing.leeCode.offer;

/*
丑数

我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。

示例:
输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

说明:
1是丑数。
n不1超过1690。
 */
public class Offer_49 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", nthUglyNumber(10));
    }

    private static int nthUglyNumber(int n) {
        int[] resultArr = new int[n];
        resultArr[0] = 1;

        int indexTwo = 0, indexThree = 0, indexFive = 0;
        int resultTwo, resultThree, resultFive;

        for (int i = 1; i < n; i++) {
            resultTwo = resultArr[indexTwo] * 2;
            resultThree = resultArr[indexThree] * 3;
            resultFive = resultArr[indexFive] * 5;

            resultArr[i] = Math.min(Math.min(resultTwo, resultThree), resultFive);
            if (resultArr[i] == resultTwo) {
                indexTwo++;
            }
            if (resultArr[i] == resultThree) {
                indexThree++;
            }
            if (resultArr[i] == resultFive) {
                indexFive++;
            }
        }

        return resultArr[n - 1];
    }

}
