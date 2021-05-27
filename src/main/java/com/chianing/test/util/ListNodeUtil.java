package com.chianing.test.util;

import com.chianing.leeCode.structure.ListNode;
import com.chianing.leeCode.structure.Node;

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

    public static Node initRandomListNode() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        // random
        head.random = null;
        head.next.random = head;
        head.next.next.random = head;

        return head;
    }

}
