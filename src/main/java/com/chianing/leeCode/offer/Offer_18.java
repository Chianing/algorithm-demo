package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

/*
给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
注意：此题对比原题有改动

示例 1:
输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2:

输入: head = [4,5,1,9], val = 1
输出: [4,5,9]
解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.

说明：
题目保证链表中节点的值互不相同

 */
public class Offer_18 {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);

        System.out.printf("delete result is: %s%n", JSONObject.toJSONString(deleteNode(node, 4)));
    }

    private static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }

        ListNode headCopy = head;
        while (headCopy.next != null && headCopy.next.val != val) {
            // 如果链表没有结束 或链表的下一个值跟目标值不相等 就继续遍历链表
            headCopy = headCopy.next;
        }

        if (headCopy.next != null) {
            // 如果因为链表下一个值与目标值相等退出循环 这里直接删除下一个值
            headCopy.next = headCopy.next.next;
        }

        return head;
    }

}
