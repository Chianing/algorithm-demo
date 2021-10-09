package com.chianing.leeCode.algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
//
// 示例：
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
//
// 提示：
// 0 <= len(arr) <= 100000
// 0 <= k <= min(100000, len(arr))
public class Q_17_14_smallestK {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestK(new int[]{1, 3, 2, 0, 5}, 5)));
    }

    public static int[] smallestK(int[] arr, int k) {
        if (k <= 0) {
            return new int[]{};
        }
        if (k >= arr.length) {
            return arr;
        }

        // 构建最大堆
        PriorityQueue<Integer> tempQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i : arr) {
            if (tempQueue.size() < k) {
                // 如果堆未满k个数 直接将当前元素添加至最大堆
                tempQueue.add(i);
            } else if (tempQueue.peek() > i) {
                // 如果堆已满k个数 且堆顶元素大于当前元素 则弹出堆顶元素 并将当前元素添加至堆内
                tempQueue.poll();
                tempQueue.add(i);
            }
        }

        // 构造返回结果
        int[] resultArr = new int[k];
        for (int i = 0; i < k && !tempQueue.isEmpty(); i++) {
            resultArr[i] = tempQueue.poll();
        }

        return resultArr;
    }
}
