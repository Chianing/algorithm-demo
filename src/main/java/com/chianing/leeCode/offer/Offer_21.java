package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

/*
调整数组顺序使奇数位于偶数前面

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

示例：
输入：nums =[1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。

提示：
0 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */
public class Offer_21 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5};
        System.out.printf("result is: %s%n", JSONObject.toJSONString(exchange(arr)));
    }

    private static int[] exchange(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int leftIndex = 0, rightIndex = nums.length - 1, temp;

        while (leftIndex < rightIndex) {
            // 从左向右找出第一个偶数
            while (leftIndex < nums.length && (nums[leftIndex] & 1) != 0) {
                leftIndex++;
            }

            // 从右向左找出第一个奇数
            while (rightIndex >= 0 && (nums[rightIndex] & 1) == 0) {
                rightIndex--;
            }

            // 交换两个元素位置
            if (leftIndex < rightIndex && leftIndex < nums.length) {
                temp = nums[leftIndex];
                // 交换完成后 直接移动一次指针
                nums[leftIndex++] = nums[rightIndex];
                nums[rightIndex--] = temp;
            }

        }

        return nums;

    }

}
