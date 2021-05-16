package com.chianing.test.tree.binary.solution;

import com.chianing.leeCode.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树 递归遍历
 */
public class RecursionSolution {

    private final List<Integer> prePrintResultList = new ArrayList<>();
    private final List<Integer> midPrintResultList = new ArrayList<>();
    private final List<Integer> aftPrintResultList = new ArrayList<>();

    /**
     * 前序遍历
     */
    public List<Integer> prePrint(TreeNode rootNode) {
        if (rootNode == null) {
            return prePrintResultList;
        }

        prePrintResultList.add(rootNode.val);
        prePrint(rootNode.left);
        prePrint(rootNode.right);

        return prePrintResultList;
    }

    /**
     * 中序遍历
     */
    public List<Integer> midPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return midPrintResultList;
        }

        midPrint(rootNode.left);
        midPrintResultList.add(rootNode.val);
        midPrint(rootNode.right);

        return midPrintResultList;
    }

    /**
     * 后序遍历
     */
    public List<Integer> aftPrint(TreeNode rootNode) {
        if (rootNode == null) {
            return aftPrintResultList;
        }

        aftPrint(rootNode.left);
        aftPrint(rootNode.right);
        aftPrintResultList.add(rootNode.val);

        return aftPrintResultList;

    }

}
