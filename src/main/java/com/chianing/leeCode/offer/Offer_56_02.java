package com.chianing.leeCode.offer;

/*
数组中数字出现的次数 II

在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：
输入：nums = [3,4,3,3]
输出：4
示例 2：
输入：nums = [9,1,7,9,7,9,7]
输出：1

限制：
1 <= nums.length <= 10000
1 <= nums[i] < 2^31
 */
public class Offer_56_02 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
    }

    private static int singleNumber(int[] nums) {
        int[] tempArr = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                tempArr[i] += num & 1;
                num >>>= 1;
            }
        }

        int result = 0, mod = 3;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            result |= tempArr[i] % mod;
        }

        return result;
    }

}
