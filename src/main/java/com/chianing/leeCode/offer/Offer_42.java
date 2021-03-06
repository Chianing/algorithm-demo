package com.chianing.leeCode.offer;

/*
连续子数组的最大和

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。

提示：
1 <=arr.length <= 10^5
-100 <= arr[i] <= 100
 */
public class Offer_42 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    private static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            result = Math.max(nums[i], result);
        }

        return result;
    }

}
