package com.chianing.leeCode.offer;

import com.chianing.test.util.ArrayUtil;

/*
礼物的最大价值

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

示例 1:
输入: 
[
 [1,3,1],
 [1,5,1],
 [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

提示：
0 < grid.length <= 200
0 < grid[0].length <= 200
 */
public class Offer_47 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", maxValue(ArrayUtil.getMatrix()));
    }

    private static int maxValue(int[][] grid) {
        int rowMax = grid.length, columnMax = grid[0].length;
        // 初始化第一列
        for (int row = 1; row < rowMax; row++) {
            grid[row][0] += grid[row - 1][0];
        }
        // 初始化第一行
        for (int column = 1; column < columnMax; column++) {
            grid[0][column] += grid[0][column - 1];
        }

        for (int row = 1; row < rowMax; row++) {
            for (int column = 1; column < columnMax; column++) {
                grid[row][column] += Math.max(grid[row - 1][column], grid[row][column - 1]);
            }
        }

        return grid[rowMax - 1][columnMax - 1];
    }

}
