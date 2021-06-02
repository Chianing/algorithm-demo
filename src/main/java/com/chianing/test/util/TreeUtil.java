package com.chianing.test.util;

import com.chianing.leeCode.structure.TreeNode;

public class TreeUtil {

    /*
       3
      / \
     9  20
       /  \
      15   7
    */
    public static TreeNode initBinaryTree() {
        TreeNode result = new TreeNode(3);
        result.left = new TreeNode(9);
        result.right = new TreeNode(20);
        result.right.left = new TreeNode(15);
        result.right.right = new TreeNode(7);

        return result;
    }

    /*
              5
             / \
            4   7
           /   /
          3   6
     */
    public static TreeNode initBinarySearchTree() {
        TreeNode result = new TreeNode(5);
        result.left = new TreeNode(4);
        result.left.left = new TreeNode(3);
        result.right = new TreeNode(7);
        result.right.left = new TreeNode(6);

        return result;
    }

}
