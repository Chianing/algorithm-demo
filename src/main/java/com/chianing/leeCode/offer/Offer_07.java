package com.chianing.leeCode.offer;

import com.chianing.leeCode.structure.TreeNode;

import java.util.HashMap;

public class Offer_07 {
    /*
          3
         / \
        9  20
          /  \
         15   7
       */
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);

        System.out.println("finish");
    }

    private static int[] preorderArr;
    private static final HashMap<Integer, Integer> dic = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderArr = preorder;
        for (int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }

    private static TreeNode recur(int root, int left, int right) {
        if (left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorderArr[root]);          // 建立根节点
        int i = dic.get(preorderArr[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
