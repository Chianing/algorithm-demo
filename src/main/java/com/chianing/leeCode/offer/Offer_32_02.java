package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

import java.util.*;

/*
从上到下打印二叉树 II

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

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
  [9,20],
  [15,7]
]

提示：
节点总数 <= 1000
 */
public class Offer_32_02 {

    public static void main(String[] args) {
        System.out.println("result is:");
        List<List<Integer>> resultList = levelOrder(TreeUtil.initBinaryTree());
        for (List<Integer> integers : resultList) {
            System.out.println(JSONObject.toJSONString(integers));
        }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            for (int size = tempQueue.size(); size > 0; size--) {
                TreeNode node = tempQueue.poll();
                if (node == null) {
                    continue;
                }
                tempList.add(node.val);

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
