package com.chianing.niuke.offer;

import java.util.Arrays;

/**
 * title: JZ1 二维数组中的查找
 * desc:
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * ---------------
 * input:   7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * output:  true
 */
public class JZ1 {

    public static void main(String[] args) {
        int target = 14;
        int[][] array1 = {};
        int[][] array2 = {
                {2, 5, 6, 7, 10, 11},
                {4, 8, 10, 13, 14, 15},
                {6, 10, 13, 15, 17, 20}
        };

        System.out.printf("case1, array1: %s\nresult is: %s%n",
                Arrays.deepToString(array1), find(target, array1));
        System.out.println("-----------------------------------");
        System.out.printf("case2, array2: %s\nresult is: %s%n",
                Arrays.deepToString(array2), find(target, array2));
    }

    /**
     * 查找数字是否出现在二维数组中
     * 数组左下角数字特点：此列数字的最大值，此行数字的最小值
     *
     * @param target 目标数字
     * @param array  目标二维数组
     * @return 是否存在
     */
    private static boolean find(int target, int[][] array) {
        if (array.length == 0 || array[0].length == 0 || target < array[0][0]) {
            return false;
        }

        // 左下角数字坐标
        int colNum = array.length - 1;
        int rowNum = 0;

        while (colNum >= 0 && rowNum < array[0].length) {
            int current = array[colNum][rowNum];
            if (current == target) {
                return true;
            } else if (current > target) {
                // 如果左下角数字比目标数字大 说明此行数据不符合要求 舍弃此行数据
                colNum--;
            } else {
                // 如果左下角数字比目标数字小 说明此列数据不符合要求 舍弃此列数据
                rowNum++;
            }
        }

        return false;

    }

}
