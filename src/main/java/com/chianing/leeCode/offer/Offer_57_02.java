package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/*
和为s的连续正数序列

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：
输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：
输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]

限制：
1 <= target <= 10^5
 */
public class Offer_57_02 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(findContinuousSequence(9)));
        System.out.printf("result is: %s%n", JSONObject.toJSONString(findContinuousSequence(15)));
    }

    private static int[][] findContinuousSequence(int target) {
        int left = 1, right = 1, sum = 0;
        List<int[]> resultList = new ArrayList<>();

        while (left <= target / 2) {
            if (sum < target) {
                // 右边界向右移动
                sum += right;
                right++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= left;
                left++;
            } else {
                int[] tempArr = new int[right - left];
                for (int i = left; i < right; i++) {
                    tempArr[i - left] = i;
                }
                resultList.add(tempArr);

                // 左边界向右移动
                sum -= left;
                left++;
            }
        }

        return resultList.toArray(new int[0][]);

    }

}
