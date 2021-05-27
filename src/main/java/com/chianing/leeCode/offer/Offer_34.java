package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
二叉树中和为某一值的路径

输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

示例:
给定如下二叉树，以及目标和target = 22，
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:
[
   [5,4,11,2],
   [5,8,4,5]
]

提示：
节点总数 <= 10000
 */
public class Offer_34 {

    public static void main(String[] args) {
        System.out.printf("result is: %s", JSONObject.toJSONString(pathSum(TreeUtil.initBinaryTree(), 30)));
    }

    private static final LinkedList<Integer> pathList = new LinkedList<>();
    private static final LinkedList<List<Integer>> resultList = new LinkedList<>();

    private static List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return Collections.emptyList();
        }

        recur(root, target);
        return resultList;
    }

    private static void recur(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        pathList.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            resultList.add(new LinkedList<>(pathList));
            pathList.removeLast();
            return;
        }

        recur(root.left, target);
        recur(root.right, target);
        pathList.removeLast();
    }

}
