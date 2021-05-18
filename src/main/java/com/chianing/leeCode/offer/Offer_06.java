package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
从尾到头打印链表

输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

示例 1：
输入：head = [1,3,2]
输出：[2,3,1]

限制：
0 <= 链表长度 <= 10000
 */
public class Offer_06 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        System.out.printf("result is: %s%n", JSONObject.toJSONString(reversePrint(node1)));

    }

    private static final List<Integer> resultList = new ArrayList<>();

    private static int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        int[] resultArr = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

    private static void getReversePrintList(ListNode node) {
        if (node == null) {
            return;
        }
        getReversePrintList(node.next);
        resultList.add(node.val);
    }

}
