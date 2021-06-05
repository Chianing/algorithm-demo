package com.chianing.leeCode.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
队列的最大值

请定义一个队列并实现函数 max_value 得到队列里的最大值，
要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value需要返回 -1

示例 1：
输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出:[null,null,null,2,1,2]

示例 2：
输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出:[null,-1,-1]

限制：
1 <= push_back,pop_front,max_value的总操作数<= 10000
1 <= value <= 10^5
 */
public class Offer_59_02 {

    public static void main(String[] args) {
        MaxQueue maxQue = new MaxQueue();
        System.out.printf("max value is: %s%n", maxQue.max_value());
        maxQue.push_back(1);
        System.out.printf("max value is: %s%n", maxQue.max_value());
        maxQue.push_back(0);
        System.out.printf("max value is: %s%n", maxQue.max_value());
        maxQue.push_back(2);
        System.out.printf("max value is: %s%n", maxQue.max_value());
        maxQue.pop_front();
        System.out.printf("max value is: %s%n", maxQue.max_value());
    }

    private static class MaxQueue {

        private final Queue<Integer> numQue;
        private final Deque<Integer> maxNumQue;

        public MaxQueue() {
            numQue = new LinkedList<>();
            maxNumQue = new LinkedList<>();
        }

        public int max_value() {
            return maxNumQue.isEmpty() ? -1 : maxNumQue.peekFirst();
        }

        public void push_back(int value) {
            numQue.add(value);
            while (!maxNumQue.isEmpty() && maxNumQue.peekLast() < value) {
                maxNumQue.removeLast();
            }
            maxNumQue.addLast(value);
        }

        public int pop_front() {
            if (numQue.isEmpty()) {
                return -1;
            }

            Integer poll = numQue.poll();
            if (poll.equals(maxNumQue.peekFirst())) {
                maxNumQue.removeFirst();
            }
            return poll;
        }
    }

}
