package com.chianing.leeCode.offer;


import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.Node;
import com.chianing.test.util.ListNodeUtil;

import java.util.HashMap;
import java.util.Map;

/*
复杂链表的复制

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。

示例 1：
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]

示例 2：
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]

示例 3：
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]

示例 4：
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。

提示：
-10000 <= Node.val <= 10000
Node.random为空（null）或指向链表中的节点。
节点数目不超过 1000 。
 */
public class Offer_35 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(copyRandomList2(ListNodeUtil.initRandomListNode())));
    }

    private static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node headCopy = head;
        Map<Node, Node> resultMap = new HashMap<>();

        while (headCopy != null) {
            resultMap.put(headCopy, new Node(headCopy.val));
            headCopy = headCopy.next;
        }

        headCopy = head;
        while (headCopy != null) {
            resultMap.get(headCopy).next = resultMap.get(headCopy.next);
            resultMap.get(headCopy).random = resultMap.get(headCopy.random);
            headCopy = headCopy.next;
        }

        return resultMap.get(head);

    }

    private static Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        Node headCopy = head;
        Node tempNode;

        // 先拷贝节点 并依次将新节点拼接到老节点后面
        while (headCopy != null) {
            tempNode = new Node(headCopy.val);
            tempNode.next = headCopy.next;
            headCopy.next = tempNode;
            headCopy = tempNode.next;
        }

        // 设置新节点的random指针
        headCopy = head;
        while (headCopy != null) {
            if (headCopy.random != null) {
                headCopy.next.random = headCopy.random.next;
            }
            headCopy = headCopy.next.next;
        }

        // 拆分出老链表和新链表
        headCopy = head;
        Node resultHeadCopy = head.next, result = head.next;
        while (resultHeadCopy.next != null) {
            headCopy.next = headCopy.next.next;
            resultHeadCopy.next = resultHeadCopy.next.next;
            headCopy = headCopy.next;
            resultHeadCopy = resultHeadCopy.next;
        }

        headCopy.next = null;

        return result;
    }

}
