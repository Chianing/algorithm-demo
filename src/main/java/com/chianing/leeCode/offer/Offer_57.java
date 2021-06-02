package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

/*
和为s的两个数字

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：
输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]

限制：
1 <= nums.length <= 10^5
1 <= nums[i]<= 10^6
 */
public class Offer_57 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.printf("result is: %s%n", JSONObject.toJSONString(twoSum(new int[]{10, 26, 30, 31, 47, 60}, 40)));
    }

    private static int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1, sum;

        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }

        return new int[]{};
    }

}
