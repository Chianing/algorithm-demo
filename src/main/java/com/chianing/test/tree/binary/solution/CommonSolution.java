package com.chianing.test.tree.binary.solution;

import com.chianing.leeCode.offer.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树 常规遍历（非递归）
 * https://www.jianshu.com/p/456af5480cee
 */
public class CommonSolution {

    /**
     * 先序遍历
     */
    public List<Integer> prePrint(TreeNode rootNode) {
        if (rootNode == null) {
            return Collections.emptyList();
        }

        TreeNode node = rootNode;
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();

        while (node != null || !tempStack.isEmpty()) {
            while (node != null) {
                resultList.add(node.val);
                tempStack.push(node);
                node = node.left;
            }

            if (!tempStack.isEmpty()) {
                node = tempStack.pop();
                node = node.right;
            }
        }

        return resultList;
    }

    /**
     * 中序遍历
     */
    public List<Integer> midPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return Collections.emptyList();
        }

        TreeNode node = rootNode;
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();

        while (node != null || !tempStack.isEmpty()) {
            while (node != null) {
                tempStack.push(node);
                node = node.left;
            }

            if (!tempStack.isEmpty()) {
                node = tempStack.pop();
                resultList.add(node.val);
                node = node.right;
            }

        }

        return resultList;

    }

    /**
     * 后序遍历
     */
    public List<Integer> aftPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return Collections.emptyList();
        }

        TreeNode node = rootNode;
        TreeNode lastVisit = rootNode;
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();

        while (node != null || !tempStack.isEmpty()) {
            while (node != null) {
                tempStack.push(node);
                node = node.left;
            }

            node = tempStack.peek();
            if (node.right == null || node.right == lastVisit) {
                resultList.add(tempStack.pop().val);
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }

        }

        return resultList;

    }

}
