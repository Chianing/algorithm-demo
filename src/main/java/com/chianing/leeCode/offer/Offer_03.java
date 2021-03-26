package com.chianing.leeCode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
找出数组中重复的数字。

在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
请找出数组中任意一个重复的数字。

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3

限制：
2 <= n <= 100000
 */
public class Offer_03 {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 2, 5, 3};
        System.out.printf("result is: %s%n", findRepeatNumber3(nums));
    }

    public static int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int num : nums) {
            if (tempMap.get(num) != null) {
                return num;
            }
            tempMap.put(num, num);
        }
        return -1;
    }

    public static int findRepeatNumber2(int[] nums) {
        Set<Integer> tempSet = new HashSet<>();
        for (int num : nums) {
            if (!tempSet.add(num)) {
                return num;
            }
            tempSet.add(num);
        }
        return -1;
    }

    /* 依次为每个坑找萝卜 将当前坑号的萝卜 放到萝卜号对应的坑 如果遇到相同的值 直接返回 */
    public static int findRepeatNumber3(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                temp = nums[i];
                if (temp == nums[temp]) {
                    return temp;
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }

}
