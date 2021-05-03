package com.chianing.test.tree.binary;


import com.alibaba.fastjson.JSONObject;
import com.chianing.leeCode.offer.structure.TreeNode;
import com.chianing.test.tree.binary.solution.CommonSolution;
import com.chianing.test.tree.binary.solution.RecursionSolution;
import com.chianing.test.util.TreeUtil;

import java.util.List;

public class TreePrint {

    public static void main(String[] args) {
        TreeNode rootNode = TreeUtil.initBinaryTree();

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

}
