package com.chianing.leeCode.other;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 删除链表倒数第n个元素
 */
public class DeleteListNode {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4);
        ListNode node = getListNode(intList);

        deleteNode(node, 2);
        System.out.println(JSONObject.toJSONString(getList(node)));

    }

    private static ListNode getListNode(List<Integer> intList) {
        ListNode result = new ListNode();
        ListNode head = result;

        for (Integer integer : intList) {
            ListNode tempNode = new ListNode();
            tempNode.val = integer;
            result.next = tempNode;
            result = result.next;
        }

        return head.next;

    }

    private static List<Integer> getList(ListNode node) {
        List<Integer> resultList = new ArrayList<>();

        while (node != null) {
            resultList.add(node.val);
            node = node.next;
        }

        return resultList;
    }

    private static void deleteNode(ListNode node, Integer n) {
        if (node == null || n == null) {
            return;
        }

        int tempIndex = 0;
        ListNode fastNode = node, slowNode = node;

        while (tempIndex < n && fastNode != null) {
            fastNode = fastNode.next;
            tempIndex++;
        }

        if (fastNode == null) {
            return;
        }

        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }

        ListNode tempNode = slowNode.next;
        slowNode.next = tempNode.next;

    }

}
