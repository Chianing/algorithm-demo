package com.chianing.leeCode.offer;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
字符串的排列

输入一个字符串，打印出该字符串中字符的所有排列。
你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

示例:
输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

限制：
1 <= s 的长度 <= 8
 */
public class Offer_38 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", JSONObject.toJSONString(permutation("abc")));
    }

    private static char[] result;
    private static final List<String> resultList = new ArrayList<>();

    private static String[] permutation(String s) {
        if (s == null || "".equals(s)) {
            return new String[]{};
        }

        result = s.toCharArray();
        dfs(0);

        return resultList.toArray(new String[]{});
    }

    private static void dfs(int index) {
        if (index == result.length - 1) {
            resultList.add(String.valueOf(result));
            return;
        }

        Set<Character> tempSet = new HashSet<>();
        for (int i = index; i < result.length; i++) {
            if (tempSet.contains(result[i])) {
                continue;
            }
            tempSet.add(result[i]);
            swap(i, index);
            dfs(index + 1);
            swap(index, i);
        }

    }

    private static void swap(int index1, int index2) {
        char temp = result[index1];
        result[index1] = result[index2];
        result[index2] = temp;
    }

}
