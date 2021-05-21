package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.ListNode;

/*
两个链表的第一个公共节点

输入两个链表，找出它们的第一个公共节点。

示例 1：
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
示例2：
输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
示例3：
输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。
 */
public class Offer_52 {

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        nodeA.next = new ListNode(2);
        nodeA.next.next = new ListNode(3);

        ListNode nodeB = new ListNode(4);
        nodeB.next = nodeA.next;

        System.out.printf("result is: %s%n", JSONObject.toJSONString(getIntersectionNode(nodeA, nodeB)));

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        /*
        若链表A长度为a 链表B长度为b 公共长度为c
        指针A先遍历链表A 遍历完成后 继续遍历B指针 则遍历到公共节点的步长为 a+(b-c)
        同理 指针B到公共节点的步长为 b+(a-c)
        则两个指针重合 a+(b-c) = b+(a-c)
         */
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;

    }

}
