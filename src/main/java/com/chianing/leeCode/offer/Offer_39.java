package com.chianing.leeCode.offer;

/*
数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2

限制：
1 <= 数组长度 <= 50000
 */
public class Offer_39 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.printf("result is: %s%n", majorityElement(arr));
    }

    /**
     * 摩尔投票法
     */
    private static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int result = 0, voteResult = 0;

        for (int num : nums) {
            if (voteResult == 0) {
                result = num;
            }
            voteResult += num == result ? 1 : -1;
        }

        return result;
    }

}
