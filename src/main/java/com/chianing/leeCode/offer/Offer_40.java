package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

import java.util.PriorityQueue;

/*
最小的k个数

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

示例 1：
输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：
输入：arr = [0,1,2,1], k = 1
输出：[0]

限制：
0 <= k <= arr.length <= 10000
0 <= arr[i]<= 10000
 */
public class Offer_40 {

    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 3, 2, 1, 1, 2, 0, 4};
        System.out.printf("result is: %s%n", JSONObject.toJSONString(getLeastNumbers(arr, 10)));
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if (k < 0 || k > arr.length) {
            return new int[]{};
        }

        PriorityQueue<Integer> tempQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : arr) {
            if (tempQueue.size() < k) {
                tempQueue.add(i);
            } else if (tempQueue.peek() != null && tempQueue.peek() > i) {
                tempQueue.poll();
                tempQueue.add(i);
            }
        }

        return tempQueue.stream().mapToInt(Integer::intValue).toArray();

    }

}
