package com.chianing.leeCode.offer;

/*
机器人的运动范围

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

示例 1：
输入：m = 2, n = 3, k = 1
输出：3
示例 2：
输入：m = 3, n = 1, k = 0
输出：1

提示：
1 <= n,m <= 100
0 <= k<= 20
 */
public class Offer_13 {

    public static void main(String[] args) {
        System.out.printf("result is %s%n", movingCount(2, 3, 1));
    }

    private static int rowMaxCopy, columnMaxCopy, stepMaxCopy;
    private static boolean[][] tempArr;

    private static int movingCount(int rowMax, int columnMax, int stepMax) {
        if (rowMax == 0 || columnMax == 0) {
            return 0;
        } else if (stepMax == 0) {
            return 1;
        }

        rowMaxCopy = rowMax;
        columnMaxCopy = columnMax;
        stepMaxCopy = stepMax;
        tempArr = new boolean[rowMaxCopy][columnMaxCopy];

        return dfs(0, 0, 0, 0);
    }

    /**
     * 深度优先遍历算法
     *
     * @param rowIndex    行索引
     * @param columnIndex 列索引
     * @param rowSum      行元素 各数位之和
     * @param columnSum   列元素 各数位之和
     */
    private static int dfs(int rowIndex, int columnIndex, int rowSum, int columnSum) {
        // 超出边界 或元素已经访问过 或不满足数位和 则返回0
        if (rowIndex >= rowMaxCopy || columnIndex >= columnMaxCopy ||
                rowSum + columnSum > stepMaxCopy || tempArr[rowIndex][columnIndex]) {
            return 0;
        }
        tempArr[rowIndex][columnIndex] = true;

        // 向下或向右移动 先计算下一次递归中 行跟列元素 各数位和
        // (rowSum + 1) % 10 == 0 ? rowSum - 8 : rowSum + 1  如18->19->20 对应9->10->2
        return 1 +
                dfs(rowIndex + 1, columnIndex, (rowIndex + 1) % 10 == 0 ? rowSum - 8 : rowSum + 1, columnSum) +
                dfs(rowIndex, columnIndex + 1, rowSum, (columnIndex + 1) % 10 == 0 ? columnSum - 8 : columnSum + 1);
    }

}
