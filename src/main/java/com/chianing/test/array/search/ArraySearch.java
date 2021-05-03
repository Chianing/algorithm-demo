package com.chianing.test.array.search;

import com.alibaba.fastjson.JSONObject;
import com.chianing.test.array.search.solution.BinarySearchSolution;
import com.chianing.test.util.ArrayUtil;

public class ArraySearch {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getSortedArr();

        System.out.printf("arr is: %s%n", JSONObject.toJSONString(arr));
        System.out.printf("find %s result index is: %s%n", 0, BinarySearchSolution.binSearch(arr, 0));
        System.out.printf("find %s result index is: %s%n", 1, BinarySearchSolution.binSearch(arr, 1));
        System.out.printf("find %s result index is: %s%n", 11, BinarySearchSolution.binSearch(arr, 11));
        System.out.printf("find %s result index is: %s%n", 15, BinarySearchSolution.binSearch(arr, 15));

    }

}
