package com.chianing.leeCode.offer;

/*
在排序数组中查找数字 I

统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

限制：
0 <= 数组长度 <= 50000
 */
public class Offer_53_01 {

    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        System.out.printf("result is: %s%n", search(arr, 8));
        System.out.printf("result is: %s%n", search(arr, 6));
    }

    private static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return binGetIndex(nums, target) - binGetIndex(nums, target - 1);

    }

    private static int binGetIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;

        while (left <= right) {
            mid = (left + right) >>> 1;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;

    }

}
