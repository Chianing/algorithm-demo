package com.chianing.leeCode.hot100;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
//
// 你可以按任意顺序返回答案。
//
//
//
// 示例 1：
//
//
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
//
//
// 示例 2：
//
//
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
//
//
// 示例 3：
//
//
//输入：nums = [3,3], target = 6
//输出：[0,1]
//
//
//
//
// 提示：
//
//
// 2 <= nums.length <= 103
// -109 <= nums[i] <= 109
// -109 <= target <= 109
// 只会存在一个有效答案
public class Hot_01 {

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 6, 11};
        int target1 = 5;
        int target2 = 1;

        System.out.printf("find %s result is: %s%n", target1, JSONObject.toJSONString(twoSum(arr, target1)));
        System.out.printf("find %s result is: %s%n", target2, JSONObject.toJSONString(twoSum(arr, target2)));

    }

    private static int[] twoSum(int[] arr, int target) {
        if (arr.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int difference = target - arr[i];
            if (tempMap.containsKey(difference)) {
                return new int[]{tempMap.get(difference), i};
            }
            tempMap.put(arr[i], i);
        }

        return new int[0];

    }

}
