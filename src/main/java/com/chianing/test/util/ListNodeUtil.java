package com.chianing.test.util;

import com.chianing.leeCode.structure.ListNode;

public class ListNodeUtil {

    public static ListNode initUnsortedListNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);

        return head;
    }

    public static ListNode initSortedListNode1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(7);

        return head;
    }

    public static ListNode initSortedListNode2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        return head;
    }

}
