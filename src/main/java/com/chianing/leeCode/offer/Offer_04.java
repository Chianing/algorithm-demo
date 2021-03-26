package com.chianing.leeCode.offer;

/*
二维数组中查找

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

示例:
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定target=5，返回true。
给定target=20，返回false。

限制：
0 <= n <= 1000
0 <= m <= 1000
*/
public class Offer_04 {

    public static void main(String[] args) {
        int target = 12;
        int[][] array = {
                {2, 5, 6, 7, 10, 11},
                {4, 8, 10, 13, 14, 15},
                {6, 10, 13, 15, 17, 20}
        };

        System.out.printf("result is: %s%n", findNumberIn2DArray(array, target));

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        // 二维数组边界
        int colMax = matrix.length - 1;
        int rowMax = matrix[0].length - 1;
        // 右上角索引边界
        int colCurr = 0;
        int rowCurr = matrix[0].length - 1;

        while (colCurr <= colMax && rowCurr >= 0) {
            int currNum = matrix[colCurr][rowCurr];
            if (currNum == target) {
                return true;
            } else if (currNum > target) {
                rowCurr--;
            } else {
                colCurr++;
            }
        }

        return false;
    }

}
