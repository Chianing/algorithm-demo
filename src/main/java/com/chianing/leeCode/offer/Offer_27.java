package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

/*
二叉树的镜像

请完成一个函数，输入一个二叉树，该函数输出它的镜像。
例如输入：
  4
 /  \
 2   7
/ \  / \
1  3 6  9
镜像输出：
  4
 /  \
 7   2
/ \  / \
9  6 3 1

示例 1：
输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]
 */
public class Offer_27 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(mirrorTree(TreeUtil.initBinaryTree())));
    }

    private static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftNode = mirrorTree(root.right);
        TreeNode rightNode = mirrorTree(root.left);

        root.left = leftNode;
        root.right = rightNode;

        return root;
    }

}
