package com.chianing.niuke.offer;

import java.util.Arrays;

/**
 * title: JZ6 旋转数组的最小数字
 * desc:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * --------------------------
 * input: [3,4,5,1,2]
 * output: 1
 */
public class JZ6 {

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {3, 4, 5, 1, 2};

        System.out.printf("case1, arr1: %s\nresult is: %s%n",
                Arrays.toString(arr1), getMinInt(arr1));
        System.out.println("------------------------------");
        System.out.printf("case2, arr2: %s\nresult is: %s%n",
                Arrays.toString(arr2), getMinInt(arr2));
    }

    /**
     * 获取旋转数组中最小元素
     *
     * @param arr 目标数组
     * @return 最小元素
     */
    private static int getMinInt(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }

        for (int i = 0; i < arr.length; i++) {
            if (i + 1 == arr.length) {
                // 如果已经查找到最后一个元素 还没有找到 则说明数组没有进行过反转 返回第一个元素
                return arr[0];
            }
            // 如果后一个数字比当前数字大 说明是在这里进行的转置
            if (arr[i + 1] < arr[i]) {
                return arr[i + 1];
            }

        }

        return 0;
    }

}
