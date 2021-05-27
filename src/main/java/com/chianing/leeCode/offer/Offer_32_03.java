package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

import java.util.*;

/*
从上到下打印二叉树 III

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:
给定二叉树:[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [20,9],
  [15,7]
]

提示：
节点总数 <= 1000
 */
public class Offer_32_03 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(levelOrder(TreeUtil.initBinaryTree())));
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int size = tempQueue.size(); size > 0; size--) {
                TreeNode node = tempQueue.poll();
                if (node == null) {
                    continue;
                }

                if ((resultList.size() & 1) != 0) {
                    tempList.addFirst(node.val);
                } else {
                    tempList.add(node.val);
                }

                if (node.left != null) {
                    tempQueue.add(node.left);
                }
                if (node.right != null) {
                    tempQueue.add(node.right);
                }

            }
            resultList.add(tempList);
        }

        return resultList;
    }

}
