package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

/*
链表中倒数第k个节点

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。

示例：
给定一个链表: 1->2->3->4->5, 和 k = 2.
返回链表 4->5.
 */
public class Offer_22 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        System.out.printf("result is: %s%n", JSONObject.toJSONString(getKthFromEnd(node, 11)));
        System.out.printf("result is: %s%n", JSONObject.toJSONString(getKthFromEnd(node, 4)));

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        int step = 0;
        ListNode firstPointer = head, secondPointer = head;

        while (firstPointer != null) {
            firstPointer = firstPointer.next;
            if (step < k) {
                step++;
            } else {
                secondPointer = secondPointer.next;
            }
        }

        if (step < k) {
            return null;
        }

        return secondPointer;

    }

}
