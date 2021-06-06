package com.chianing.leeCode.offer;

import java.util.HashSet;
import java.util.Set;

/*
扑克牌中的顺子

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例1:
输入: [1,2,3,4,5]
输出: True
示例2:
输入: [0,0,1,2,5]
输出: True

限制：
数组长度为 5
数组的数取值为 [0, 13] .
 */
public class Offer_61 {

    public static void main(String[] args) {
        System.out.printf("result is: %s%n", isStraight(new int[]{0, 0, 1, 2, 5}));
    }

    private static boolean isStraight(int[] nums) {
        int min = 14, max = 0;
        Set<Integer> tempSet = new HashSet<>();

        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (tempSet.contains(num)) {
                return false;
            }

            tempSet.add(num);
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        return max - min < 5;
    }

}
