package com.chianing.leeCode.offer;

import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

/*
二叉树的深度

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
例如：
给定二叉树 [3,9,20,null,null,15,7]，
    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。

提示：
节点总数 <= 10000
 */
public class Offer_55_01 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.initBinaryTree();
        System.out.printf("result is: %s%n", maxDepth(treeNode));
    }

    private static int maxDepth(TreeNode root) {
        return root == null ? 0 :
                Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
