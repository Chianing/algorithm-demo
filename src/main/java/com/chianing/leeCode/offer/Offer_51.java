package com.chianing.leeCode.offer;

/*
数组中的逆序对

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例 1:
输入: [7,5,6,4]
输出: 5

限制：
0 <= 数组长度 <= 50000
 */
public class Offer_51 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", reversePairs(new int[]{7, 5, 6, 4}));
    }

    private static int count = 0;
    private static int[] numsCopy;

    private static int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        numsCopy = nums;
        merge(0, nums.length - 1);

        return count;
    }

    private static void merge(int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + ((right - left) >>> 1);
        merge(left, mid);
        merge(mid + 1, right);
        mergeSort(left, right, mid);
    }

    private static void mergeSort(int left, int right, int mid) {
        int[] tempArr = new int[right - left + 1];
        int index = 0, leftStart = left, rightStart = mid + 1;

        while (leftStart <= mid && rightStart <= right) {
            if (numsCopy[leftStart] <= numsCopy[rightStart]) {
                tempArr[index++] = numsCopy[leftStart++];
            } else {
                // 统计逆序对
                count += mid - leftStart + 1;
                tempArr[index++] = numsCopy[rightStart++];
            }
        }

        while (leftStart <= mid) {
            tempArr[index++] = numsCopy[leftStart++];
        }
        while (rightStart <= right) {
            tempArr[index++] = numsCopy[rightStart++];
        }

        System.arraycopy(tempArr, 0, numsCopy, left, tempArr.length);
    }

}
