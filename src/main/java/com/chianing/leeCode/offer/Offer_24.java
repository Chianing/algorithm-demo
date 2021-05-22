package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;
import com.chianing.test.util.ListNodeUtil;

/*
反转链表

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL

限制：
0 <= 节点个数 <= 5000
 */
public class Offer_24 {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.initUnsortedListNode();
        // System.out.printf("reverse result is: %s%n", JSONObject.toJSONString(reverseList1(listNode)));
        System.out.printf("reverse result is: %s%n", JSONObject.toJSONString(reverseList2(listNode)));

    }

    /**
     * 双指针
     */
    private static ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode tempPointer = null, slowPointer = null, fastPointer = head;

        while (fastPointer != null) {
            tempPointer = fastPointer.next;
            fastPointer.next = slowPointer;
            slowPointer = fastPointer;
            fastPointer = tempPointer;
        }

        return slowPointer;

    }

    /**
     * 递归
     */
    private static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return tempNode;
    }

}
