package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.structure.TreeNode;
import com.chianing.test.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

/*
序列化二叉树

请实现两个函数，分别用来序列化和反序列化二叉树。

示例:
你可以将以下二叉树：
    1
   / \
  2   3
     / \
    4   5
序列化为 "[1,2,3,null,null,4,5]"
 */
public class Offer_37 {

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serializeStr = codec.serialize(TreeUtil.initBinaryTree());
        System.out.printf("serialize result is: %s%n", serializeStr);

        TreeNode result = codec.deserialize(serializeStr);
        System.out.printf("result is: %s%n", JSONObject.toJSONString(result));
    }

    private static class Codec {

        /**
         * 层次遍历
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder result = new StringBuilder().append("[");
            Queue<TreeNode> tempQueue = new LinkedList<>();
            tempQueue.add(root);

            while (!tempQueue.isEmpty()) {
                TreeNode node = tempQueue.poll();
                if (node == null) {
                    result.append("null,");
                    continue;
                }
                result.append(node.val).append(",");

                tempQueue.add(node.left);
                tempQueue.add(node.right);
            }

            return result.deleteCharAt(result.length() - 1).append("]").toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || "".equals(data) || "[]".equals(data)) {
                return null;
            }

            String[] dataArr = data.substring(1, data.length() - 1).split(",");
            TreeNode result = new TreeNode(Integer.parseInt(dataArr[0]));
            Queue<TreeNode> tempQueue = new LinkedList<>();
            tempQueue.add(result);
            int index = 1;

            while (!tempQueue.isEmpty()) {
                TreeNode node = tempQueue.poll();
                if (node == null) {
                    continue;
                }

                if (!"null".equals(dataArr[index])) {
                    node.left = new TreeNode(Integer.parseInt(dataArr[index]));
                    tempQueue.add(node.left);
                }
                index++;

                if (!"null".equals(dataArr[index])) {
                    node.right = new TreeNode(Integer.parseInt(dataArr[index]));
                    tempQueue.add(node.right);
                }
                index++;
            }

            return result;
        }
    }

}
