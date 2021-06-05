package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.LinkedList;

/*
滑动窗口的最大值

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释:
  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

提示：
你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 */
public class Offer_59_01 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if (length == 0 || k == 0) {
            return new int[]{};
        }

        Deque<Integer> deque = new LinkedList<>();
        int[] resultArr = new int[length - k + 1];

        // 元素不够 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }

        resultArr[0] = deque.getFirst();
        // 形成窗口
        for (int i = k; i < length; i++) {
            // 如果队首元素被移出窗口
            if (deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && deque.getLast() < nums[i]) {
                deque.removeLast();
            }

            deque.addLast(nums[i]);
            resultArr[i - k + 1] = deque.getFirst();
        }

        return resultArr;
    }

}
