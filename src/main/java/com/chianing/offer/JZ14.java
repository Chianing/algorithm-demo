package com.chianing.offer;

import java.util.Stack;

/**
 * title: JZ14 链表中倒数第k个结点
 * desc:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * --------------------------
 * input: {1,2,3,4,5},1
 * output: {5}
 */
public class JZ14 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        System.out.printf("method1 result is %s%n", getLastIndexNode1(node1, 1).val);
        System.out.printf("method2 result is %s%n", getLastIndexNode2(node1, 1).val);

    }

    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode getLastIndexNode1(ListNode node, int lastIndex) {
        if (node == null) {
            return null;
        }

        // 先反转链表
        Stack<ListNode> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.next;
        }

        if (lastIndex > nodeStack.size() || lastIndex == 0) {
            return null;
        }

        for (int i = 0; i < lastIndex - 1; i++) {
            nodeStack.pop();
        }

        return nodeStack.pop();

    }

    /**
     * 两个指针遍历链表 速度相差lastIndex
     * 当快指针遍历完整个链表后 慢指针刚好在目标位置
     */
    private static ListNode getLastIndexNode2(ListNode node, int lastIndex) {
        if (node == null) {
            return null;
        }

        int currentIndex = 0;
        ListNode first = node;
        ListNode second = node;
        while (first != null) {
            first = first.next;
            if (currentIndex >= lastIndex) {
                second = second.next;
            }
            currentIndex++;
        }

        return second;
    }


}
