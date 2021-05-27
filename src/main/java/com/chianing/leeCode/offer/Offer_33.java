package com.chianing.leeCode.offer;

/*
二叉搜索树的后序遍历序列

输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：
     5
    / \
   2   6
  / \
 1   3

示例 1：
输入: [1,6,3,2,5]
输出: false
示例 2：
输入: [1,3,2,6,5]
输出: true

提示：
数组长度 <= 1000
 */
public class Offer_33 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", verifyPostorder(new int[]{1, 3, 2, 6, 5}));
    }

    private static boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }

        return recur(postorder, 0, postorder.length - 1);
    }

    private static boolean recur(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }

        int maxStart = start, minEnd;

        while (postorder[maxStart] < postorder[end]) {
            maxStart++;
        }
        minEnd = maxStart;

        while (postorder[maxStart] > postorder[end]) {
            maxStart++;
        }

        return maxStart == end && recur(postorder, start, minEnd - 1) && recur(postorder, minEnd, end - 1);

    }

}
