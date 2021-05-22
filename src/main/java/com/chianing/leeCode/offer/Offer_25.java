package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;
import com.chianing.test.util.ListNodeUtil;

/*
合并两个排序的链表

输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

限制：
0 <= 链表长度 <= 1000
 */
public class Offer_25 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(mergeTwoLists(ListNodeUtil.initSortedListNode1(), ListNodeUtil.initSortedListNode2())));
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode result = new ListNode(), tempNode = result;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                tempNode.next = l2;
                l2 = l2.next;
            } else {
                tempNode.next = l1;
                l1 = l1.next;
            }
            tempNode = tempNode.next;
        }

        // l1或l2已经遍历完 直接将剩余节点添加到结果链表中
        tempNode.next = l1 == null ? l2 : l1;

        return result.next;
    }

}
