package com.chianing.leeCode.hot100;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//
//
// 示例 1：
//
//
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
//
//
// 示例 2：
//
//
//输入：l1 = [0], l2 = [0]
//输出：[0]
//
//
// 示例 3：
//
//
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
//
//
//
//
// 提示：
//
//
// 每个链表中的节点数在范围 [1, 100] 内
// 0 <= Node.val <= 9
// 题目数据保证列表表示的数字不含前导零
//
// Related Topics 递归 链表 数学
// 👍 6187 👎 0

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

public class Hot_02 {

    private static ListNode node1;
    private static ListNode node2;

    public static void main(String[] args) {
        initListNodes();

        System.out.printf("add to ListNode result is: %s%n", JSONObject.toJSONString(addTwoNumbers(node1, node2)));
    }

    private static void initListNodes() {
        node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(9);
        node1.next.next.next = new ListNode(9);

        node2 = new ListNode(9);
        node2.next = new ListNode(9);

        // node1 = new ListNode(3);
        // node1.next = new ListNode(7);
        //
        // node2 = new ListNode(9);
        // node2.next = new ListNode(2);
    }

    private static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }

        ListNode resultNode = new ListNode();
        ListNode tempNode = resultNode;
        int sum;
        int extraNum = 0;

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                // 链表1已经遍历完 直接取链表2的值
                sum = node2.val + extraNum;
                node2 = node2.next;
            } else if (node2 == null) {
                // 链表2已经遍历完 直接取链表1的值
                sum = node1.val + extraNum;
                node1 = node1.next;
            } else {
                // 两个链表都没有遍历完 取该位置节点相加 如果结果大于10 则下一位进行求和时 加1
                sum = node1.val + node2.val + extraNum;
                node1 = node1.next;
                node2 = node2.next;
            }

            tempNode.next = new ListNode(sum % 10);
            extraNum = sum / 10;
            tempNode = tempNode.next;
        }

        if (extraNum != 0) {
            tempNode.next = new ListNode(extraNum);
        }
        return resultNode.next;

    }

}
