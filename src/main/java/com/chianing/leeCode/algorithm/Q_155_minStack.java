package com.chianing.leeCode.algorithm;

import java.util.Stack;

/*
最小栈

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop()—— 删除栈顶的元素。
top()—— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

示例:
输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
输出：
[null,null,null,null,-3,null,0,-2]
解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

提示：
pop、top 和 getMin 操作总是在 非空栈 上调用。
 */
public class Q_155_minStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        System.out.printf("top result is: %s%n", minStack.top());
        minStack.push(1);
        System.out.printf("min result is: %s%n", minStack.getMin());
        minStack.push(2);
        System.out.printf("min result is: %s%n", minStack.getMin());
        minStack.pop();
        minStack.push(-1);
        System.out.printf("min result is: %s%n", minStack.getMin());
    }

    private static class MinStack {

        private final Stack<Integer> numStack;
        private final Stack<Integer> minNumStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            numStack = new Stack<>();
            minNumStack = new Stack<>();
        }

        public void push(int val) {
            numStack.push(val);
            if (minNumStack.isEmpty() || minNumStack.peek() >= val) {
                minNumStack.push(val);
            }
        }

        public void pop() {
            Integer popVal = numStack.pop();
            if (popVal.equals(minNumStack.peek())) {
                minNumStack.pop();
            }
        }

        public int top() {
            return numStack.peek();
        }

        public int getMin() {
            return minNumStack.peek();
        }
    }

}
