package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

/*
数组中数字出现的次数

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

示例 1：
输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：
输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]

限制：
2 <= nums.length <= 10000
 */
public class Offer_56_01 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
    }

    private static int[] singleNumbers(int[] nums) {
        // 存储异或结果
        int tempInt = 0;

        // 计算整个数组的异或值
        for (int num : nums) {
            tempInt ^= num;
        }

        // 找出能区别仅出现一次的两数的mask
        int mask = 1;
        while ((mask & tempInt) == 0) {
            mask <<= 1;
        }

        // 分组 计算出两组分别的异或值
        int resultA = 0, resultB = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                resultA ^= num;
            } else {
                resultB ^= num;
            }
        }

        return new int[]{resultA, resultB};
    }
}
