package com.chianing.leeCode.offer;

import java.util.Stack;

/*
用两个栈实现一个队列

队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead操作返回 -1 )

示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

提示：
1 <= values <= 10000
最多会对appendTail、deleteHead 进行10000次调用
 */
public class Offer_09 {

    public static void main(String[] args) {

        CQueue2 obj = new CQueue2();
        obj.appendTail(1);
        obj.appendTail(2);
        System.out.printf("pop result is: %s%n", obj.deleteHead());

        obj.appendTail(3);
        System.out.printf("pop result is %s%n", obj.deleteHead());
        System.out.printf("pop result is %s%n", obj.deleteHead());
        System.out.printf("pop result is %s%n", obj.deleteHead());

    }

    private static class CQueue1 {
        private final Stack<Integer> inputStack;
        private final Stack<Integer> tempStack;

        public CQueue1() {
            inputStack = new Stack<>();
            tempStack = new Stack<>();
        }

        public void appendTail(int value) {
            inputStack.push(value);
        }

        public int deleteHead() {
            if (inputStack.isEmpty()) {
                return -1;
            }

            transferStackContent(inputStack, tempStack);
            Integer result = tempStack.pop();
            transferStackContent(tempStack, inputStack);

            return result;
        }

        private void transferStackContent(Stack<Integer> sourceStack, Stack<Integer> targetStack) {
            targetStack.clear();

            while (!sourceStack.isEmpty()) {
                targetStack.push(sourceStack.pop());
            }
        }
    }

    private static class CQueue2 {
        private final Stack<Integer> inputStack;
        private final Stack<Integer> outputStack;

        public CQueue2() {
            inputStack = new Stack<>();
            outputStack = new Stack<>();
        }

        public void appendTail(int value) {
            inputStack.push(value);
        }

        public int deleteHead() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }

            if (outputStack.isEmpty()) {
                return -1;
            }

            return outputStack.pop();
        }

    }

}
