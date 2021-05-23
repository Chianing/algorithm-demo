package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

/*
打印从1到最大的n位数

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：
用返回一个整数列表来代替打印
n 为正整数
 */
public class Offer_17 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(printNumbers(3)));
        // printNumbers2(2);
        // System.out.printf("result is: %s%n", JSONObject.toJSONString(resultArr));
    }

    private static int[] printNumbers(int n) {
        if (n == 0) {
            return new int[0];
        }

        int maxNum = (int) Math.pow(10, n) - 1;
        int[] resultArr = new int[maxNum];

        for (int i = 0; i < maxNum; i++) {
            resultArr[i] = i + 1;
        }

        return resultArr;

    }


    private static char[] num;
    private static int numCount, subStartIndex, nineCount, currentCount = 0;
    private static String[] resultArr;
    private static final char[] numArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    private static void printNumbers2(int n) {
        if (n == 0) {
            return;
        }

        numCount = n;
        num = new char[numCount];
        subStartIndex = numCount - 1;
        resultArr = new String[(int) Math.pow(10, numCount) - 1];

        getNum(0);
    }

    private static void getNum(int count) {
        if (count == numCount) {
            String numStr = String.valueOf(num).substring(subStartIndex);
            if (!"0".equals(numStr)) {
                resultArr[currentCount++] = numStr;
            }
            if (numCount - subStartIndex == nineCount) {
                subStartIndex--;
            }
            return;
        }

        for (char c : numArr) {
            if (c == '9') {
                nineCount++;
            }
            num[count] = c;
            getNum(count + 1);
        }

        nineCount = 0;

    }

}
