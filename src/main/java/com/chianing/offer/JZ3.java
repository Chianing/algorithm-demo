package com.chianing.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * title: JZ3 从尾到头打印链表
 * desc:
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * ------------------
 * input: {67,0,24,58}
 * output: [58,24,0,67]
 */
public class JZ3 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;

        System.out.printf("method1 result is %s%n", reverseLinkedList1(node1).toString());
        System.out.printf("method2 result is %s%n", reverseLinkedList2(node1).toString());
        System.out.printf("method3 result is %s%n", reverseLinkedList3(node1).toString());

    }

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ArrayList<Integer> reverseLinkedList1(ListNode listNode) {
        ArrayList<Integer> resultList = new ArrayList<>();
        if (listNode == null) {
            return resultList;
        }

        while (listNode != null) {
            resultList.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(resultList);
        return resultList;
    }

    private static ArrayList<Integer> reverseLinkedList2(ListNode listNode) {
        Stack<Integer> resultStack = new Stack<>();
        if (listNode == null) {
            return new ArrayList<>();
        }

        while (listNode != null) {
            resultStack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            resultList.add(resultStack.pop());
        }
        return resultList;
    }

    private static final ArrayList<Integer> VAL_LIST = new ArrayList<>();

    /**
     * 递归算法
     */
    private static ArrayList<Integer> reverseLinkedList3(ListNode listNode) {
        if (listNode != null) {
            reverseLinkedList3(listNode.next);
            VAL_LIST.add(listNode.val);
        }
        return VAL_LIST;

    }

}
