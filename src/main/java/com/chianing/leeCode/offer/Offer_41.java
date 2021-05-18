package com.chianing.leeCode.offer;

import java.util.PriorityQueue;

/*
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
例如，
[2,3,4]的中位数是 3
[2,3] 的中位数是 (2 + 3) / 2 = 2.5
设计一个支持以下两种操作的数据结构：
void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。

示例 1：
输入：
["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
[[],[1],[2],[],[3],[]]
输出：[null,null,null,1.50000,null,2.00000]
示例 2：
输入：
["MedianFinder","addNum","findMedian","addNum","findMedian"]
[[],[2],[],[3],[]]
输出：[null,null,2.00000,null,2.50000]

限制：
最多会对addNum、findMedian 进行50000次调用。。
 */
public class Offer_41 {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(-1);
        System.out.printf("result is %s%n", obj.findMedian());
        obj.addNum(-2);
        System.out.printf("result is %s%n", obj.findMedian());
        obj.addNum(-3);
        System.out.printf("result is %s%n", obj.findMedian());
        obj.addNum(-4);
        System.out.printf("result is %s%n", obj.findMedian());
        obj.addNum(-5);
        System.out.printf("result is %s%n", obj.findMedian());
    }

    private static class MedianFinder {
        private final PriorityQueue<Integer> minQue;
        private final PriorityQueue<Integer> maxQue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            minQue = new PriorityQueue<>((o1, o2) -> o2 - o1);
            maxQue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxQue.size() != minQue.size()) {
                // 元素个数不相等 说明最大堆中元素比最小堆中多 将新元素放入最小堆
                maxQue.add(num);
                minQue.add(maxQue.poll());
            } else {
                // 元素个数相等 将新元素放入最大堆
                minQue.add(num);
                maxQue.add(minQue.poll());
            }

        }

        public double findMedian() {
            if (maxQue.size() == 0) {
                return 0.0;
            }
            // 元素个数为奇数时 直接取最大堆堆顶元素 否则取最大、最小堆堆顶元素计算平均值
            return maxQue.size() == minQue.size() ?
                    (maxQue.peek() + minQue.peek()) * 0.5 : maxQue.peek() * 1.0;
        }
    }

}
