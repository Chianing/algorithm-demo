package com.chianing.leeCode.offer;

import java.util.Stack;

/*
包含min函数的栈

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

示例:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.

提示：
各函数的调用总次数不超过 20000 次
 */
public class Offer_30 {

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(1);
        System.out.printf("top result is: %s%n", obj.top());
        obj.push(1);
        System.out.printf("min result is: %s%n", obj.min());
        obj.push(2);
        System.out.printf("min result is: %s%n", obj.min());
        obj.pop();
        obj.push(-1);
        System.out.printf("min result is: %s%n", obj.min());

    }

    private static class MinStack {
        Stack<Integer> mainStack;
        Stack<Integer> tempStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            mainStack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void push(int x) {
            mainStack.push(x);
            if (tempStack.isEmpty() || tempStack.peek() >= x) {
                tempStack.push(x);
            }
        }

        public void pop() {
            if (mainStack.isEmpty()) {
                return;
            }

            Integer num = mainStack.pop();
            if (!tempStack.isEmpty() && tempStack.peek().equals(num)) {
                tempStack.pop();
            }
        }

        public int top() {
            return mainStack.peek();
        }

        public int min() {
            return tempStack.peek();
        }
    }
}
