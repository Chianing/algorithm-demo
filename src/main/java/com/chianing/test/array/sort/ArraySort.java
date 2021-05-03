package com.chianing.test.array.sort;

import com.alibaba.fastjson.JSONObject;
import com.chianing.test.array.sort.solution.QuickSort;
import com.chianing.test.util.ArrayUtil;

public class ArraySort {

    public static void main(String[] args) {
        int[] arr = ArrayUtil.getUnsortedArr();
        System.out.printf("arr is %s%n", JSONObject.toJSONString(arr));
        QuickSort.sortArr(arr);
        System.out.printf("sort result is %s%n", JSONObject.toJSONString(arr));
    }

}
