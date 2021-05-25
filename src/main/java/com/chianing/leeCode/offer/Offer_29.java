package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.test.util.ArrayUtil;

/*
顺时针打印矩阵

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

限制：
0 <= matrix.length <= 100
0 <= matrix[i].length<= 100
 */
public class Offer_29 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(spiralOrder(ArrayUtil.getMatrix())));
    }


    private static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int left = 0, right = matrix[0].length - 1, below = matrix.length - 1, top = 0, index = 0;
        int[] resultArr = new int[(right + 1) * (below + 1)];

        while (true) {
            for (int i = left; i <= right; i++) {
                // 从左到右
                resultArr[index++] = matrix[top][i];
            }
            if (++top > below) {
                break;
            }
            for (int i = top; i <= below; i++) {
                // 从上到下
                resultArr[index++] = matrix[i][right];
            }
            if (left > --right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                // 从右到左
                resultArr[index++] = matrix[below][i];
            }
            if (top > --below) {
                break;
            }
            for (int i = below; i >= top; i--) {
                // 从下到上
                resultArr[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }

        }

        return resultArr;
    }

}
