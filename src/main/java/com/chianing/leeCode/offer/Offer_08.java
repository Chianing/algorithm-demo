package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如，给出
前序遍历 preorder =[3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

限制：
0 <= 节点个数 <= 5000
 */
public class Offer_08 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.printf("result is: %s%n", JSONObject.toJSONString(solution.buildTree(new int[]{3, 9, 20, 15, 7, 8}, new int[]{9, 3, 15, 20, 7, 8})));
    }

    private static class Solution {
        private final Map<Integer, Integer> inorderMap = new HashMap<>();
        private int[] preOrderCopy;

        private TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 0 || inorder.length == 0) {
                return null;
            }

            this.preOrderCopy = preorder;
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            return getNode(0, 0, preOrderCopy.length - 1);

        }

        private TreeNode getNode(int preRootIndex, int inLeftIndex, int inRightIndex) {
            if (inLeftIndex > inRightIndex) {
                return null;
            }

            // 根据前序遍历 获取根节点
            TreeNode node = new TreeNode(this.preOrderCopy[preRootIndex]);

            Integer inRootIndex = inorderMap.get(preOrderCopy[preRootIndex]);
            // 获取左子树
            node.left = getNode(preRootIndex + 1, inLeftIndex, inRootIndex - 1);
            // 获取右子树 inRootIndex-inLeftIndex+1为利用中序数组中 左子树元素个数 判断出右子树根节点index
            node.right = getNode(preRootIndex + (inRootIndex - inLeftIndex + 1), inRootIndex + 1, inRightIndex);

            return node;
        }
    }

}
