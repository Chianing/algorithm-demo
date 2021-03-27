package com.chianing.test.tree.binary;


import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.offer.structure.TreeNode;
import com.chianing.test.tree.binary.solution.CommonSolution;
import com.chianing.test.tree.binary.solution.RecursionSolution;

import java.util.List;

public class TreePrint {

    private static TreeNode rootNode;

    public static void main(String[] args) {
        initBinaryTree();

        // 递归遍历
        RecursionSolution recursionSolution = new RecursionSolution();
        List<Integer> prePrintResult1 = recursionSolution.prePrint(rootNode);
        List<Integer> midPrintResult1 = recursionSolution.midPrint(rootNode);
        List<Integer> aftPrintResult1 = recursionSolution.aftPrint(rootNode);

        System.out.println("recursion print result: ");
//        System.out.printf("prePrintResult is: %s%n", JSONObject.toJSONString(prePrintResult1));
//        System.out.printf("midPrintResult is: %s%n", JSONObject.toJSONString(midPrintResult1));
        System.out.printf("aftPrintResult is: %s%n", JSONObject.toJSONString(aftPrintResult1));

        // 非递归遍历
        CommonSolution commonSolution = new CommonSolution();
        List<Integer> prePrintResult2 = commonSolution.prePrint(rootNode);
        List<Integer> midPrintResult2 = commonSolution.midPrint(rootNode);
        List<Integer> aftPrintResult2 = commonSolution.aftPrint(rootNode);

        System.out.println("not recursion print result: ");
//        System.out.printf("prePrintResult is: %s%n", JSONObject.toJSONString(prePrintResult2));
//        System.out.printf("midPrintResult is: %s%n", JSONObject.toJSONString(midPrintResult2));
        System.out.printf("aftPrintResult is: %s%n", JSONObject.toJSONString(aftPrintResult2));

    }

    /*
        3
       / \
      9  20
        /  \
       15   7
     */
    private static void initBinaryTree() {
        rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);
    }
}
