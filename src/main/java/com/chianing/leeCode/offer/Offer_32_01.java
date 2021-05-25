package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
从上到下打印二叉树

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树:[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]

提示：
节点总数 <= 1000
 */
public class Offer_32_01 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(levelOrder(TreeUtil.initBinaryTree())));
    }

    private static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }

        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {
            TreeNode node = tempQueue.poll();
            resultList.add(node.val);
            if (node.left != null) {
                tempQueue.add(node.left);
            }
            if (node.right != null) {
                tempQueue.add(node.right);
            }
        }

        int[] resultArr = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArr[i] = resultList.get(i);
        }

        return resultArr;
    }

}
